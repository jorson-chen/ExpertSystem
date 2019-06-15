package applications.model;

/*
 * ResultDescription.java
 *
 * Version: 1.0
 *
 * Revisions:
 */
public class ResultDescription {

    private int id;
    private String metric;
    private String name;
    private int maxScore;
    private String info;

    public ResultDescription(String metric) {
        this.metric = metric;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
