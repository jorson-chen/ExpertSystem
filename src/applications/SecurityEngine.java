package applications;

import applications.model.EvaluationResult;
import applications.model.PhoneInfo;
import jess.Filter;
import jess.JessException;
import jess.Rete;
import jess.WorkingMemoryMarker;

import java.util.Iterator;

/*
 * SecurityEngine.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class SecurityEngine {
    private Rete engine;
    private WorkingMemoryMarker marker;
    private PhoneInfo phoneInfo;

    public SecurityEngine(PhoneInfo phoneInfo) throws JessException {
        // Create a Jess rule engine
        engine = new Rete();
        engine.reset();

        // Load the evaluation rules
        engine.batch("rules.clp");

        this.phoneInfo = phoneInfo;

        engine.add(phoneInfo);

        marker = engine.mark();
    }

    public Iterator run(PhoneInfo phoneInfo) throws JessException {
        // Remove any previous order data, leaving only catalog data
        engine.resetToMark(marker);

        // Fire the rules that apply to this order
        engine.run();

        // Return the result of Evaluation created by the rules
        return engine.getObjects(new Filter.ByClass(EvaluationResult.class));
    }
}
