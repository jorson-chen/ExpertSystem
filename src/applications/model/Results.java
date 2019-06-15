package applications.model;

import java.util.List;

/*
 * Results.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class Results {

    List<ResultDescription> resultDescription;

    public Results(List<ResultDescription> resultDescription) {
        this.resultDescription = resultDescription;
    }

    public List<ResultDescription> getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(List<ResultDescription> resultDescription) {
        this.resultDescription = resultDescription;
    }
}
