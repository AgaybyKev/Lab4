public class Delivery {
    private String type;
    private String scheduledTime;

    // ✅ Required for Jackson
    public Delivery() {}

    public Delivery(String type, String scheduledTime) {
        this.type = type;
        this.scheduledTime = scheduledTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}