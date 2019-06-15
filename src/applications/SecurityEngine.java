package applications;

import applications.model.*;
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
    private BasicInfo basicInfo;
    private SecurityInfo securityInfo;
    private SensorInfo[] sensorInfos;
    private AppInfo[] appInfos;

    public SecurityEngine(BasicInfo basicInfo, SecurityInfo securityInfo,
                          SensorInfo[] sensorInfos, AppInfo[] appInfos) throws JessException {
        // Create a Jess rule engine
        engine = new Rete();
        engine.reset();

        // Load the evaluation rules
        engine.batch("rules.clp");

        this.basicInfo = basicInfo;

        engine.add(basicInfo);
        engine.add(securityInfo);
        engine.add(sensorInfos);
        engine.add(appInfos);

        marker = engine.mark();
    }

    public Iterator run() throws JessException {
        // Remove any previous order data, leaving only catalog data
        engine.resetToMark(marker);


        // Fire the rules that apply to this order
        engine.run();

//        engine.getOutStream();

        // Return the result of Evaluation created by the rules
        return engine.getObjects(new Filter.ByClass(EvaluationResult.class));
    }
}
