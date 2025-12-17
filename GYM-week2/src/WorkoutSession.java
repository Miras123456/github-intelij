public class WorkoutSession {
    private int sessionId;
    private String memberName;
    private String trainer;
    private int duration;

    public WorkoutSession(int sessionId, String memberName, String trainer, int duration) {
        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainer = trainer;
        this.duration = duration;
    }

    public int getSessionId() {
        return sessionId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTrainer() {
        return trainer;
    }

    public int getDuration() {
        return duration;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String extend() {
        double extraMinutes = duration / (duration * 0.05);
        this.duration += extraMinutes;
        return ("Session extended by " + extraMinutes + " minutes");
    }

    public String complete() {
        return ("workout session " + sessionId + " completed!");
    }


    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainer='" + trainer + '\'' +
                ", duration=" + duration +
                '}';
    }

}