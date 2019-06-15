package applications.model;

/*
 * EvaluationResult.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class EvaluationResult {

    private String metric;
    private int score;

    public EvaluationResult(String metric, int score) {
        this.metric = metric;
        this.score = score;
    }

    @Override
    public String toString() {
        return "EvaluationResult{" +
                "metric='" + metric + '\'' +
                ", score=" + score +
                '}';
    }
}
