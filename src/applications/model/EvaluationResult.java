package applications.model;

/*
 * EvaluationResult.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class EvaluationResult {

    String metric;
    int score;

    public EvaluationResult(String metric, int score) {
        this.metric = metric;
        this.score = score;
    }
}
