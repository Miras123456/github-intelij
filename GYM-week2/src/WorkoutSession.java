public class WorkoutSession {
    private int sessionId;
    private String memberName;
    private String trainerName;
    private int duration;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int duration) {
        this.setSessionId(sessionId);
        this.setMemberName(memberName);
        this.setTrainerName(trainerName);
        this.setDuration(duration);
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(int sessionId) {
        if (sessionId > 0) {
            this.sessionId = sessionId;
        } else {
            System.out.println("Session ID must be positive. Set to 1.");
            this.sessionId = 1;
        }
    }

    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String memberName) {
        if (memberName != null && !memberName.trim().isEmpty()) {
            this.memberName = memberName;
        } else {
            this.memberName = "Unknown";
        }
    }

    public String getTrainerName() {
        return this.trainerName;
    }

    public void setTrainerName(String trainerName) {
        if (trainerName != null && !trainerName.trim().isEmpty()) {
            this.trainerName = trainerName;
        } else {
            this.trainerName = "Unknown";
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Duration must be positive. Set to 30.");
            this.duration = 30;
        }
    }

    public void extend() {
        int extraMinutes = (int) (this.duration * 0.05);
        this.duration = this.duration + extraMinutes;
    }

    public String complete() {
        return "Workout session " + this.sessionId + " completed!";
    }

    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + this.sessionId +
                ", memberName='" + this.memberName + '\'' +
                ", trainerName='" + this.trainerName + '\'' +
                ", duration=" + this.duration +
                '}';
    }
}
