package applications.model;

/*
 * EvaluationResult.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class EvaluationResult {

    private final String metric;
    private final int score;

    public EvaluationResult(String metric, int score) {
        this.metric = metric;
        this.score = score;
    }

    public String getMetric() {
        return metric;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "EvaluationResult{" +
                "metric='" + metric + '\'' +
                ", score=" + score +
                '}';
    }
}
