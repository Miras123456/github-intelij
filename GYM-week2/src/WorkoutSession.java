public class WorkoutSession {
    protected int sessionId;
    protected Member member;
    protected Trainer trainer;
    protected int duration;

    public WorkoutSession(int sessionId, Member member, Trainer trainer, int duration) {
        setSessionId(sessionId);
        setMember(member);
        setTrainer(trainer);
        setDuration(duration);
    }

    public void setSessionId(int sessionId) {
        if (sessionId > 0) {
            this.sessionId = sessionId;
        } else {
            System.out.println("Invalid session ID. Set to 1.");
            this.sessionId = 1;
        }
    }

    public void setMember(Member member) {
        if (member != null) {
            this.member = member;
        } else {
            System.out.println("Invalid member.");
        }
    }

    public void setTrainer(Trainer trainer) {
        if (trainer != null) {
            this.trainer = trainer;
        } else {
            System.out.println("Invalid trainer.");
        }
    }

    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Invalid duration. Set to 30.");
            this.duration = 30;
        }
    }

    public void start() {
        System.out.println("Workout started for " + member.getName());
    }

    public String getType() {
        return "General Workout";
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " +
                "Session " + sessionId +
                " | Member: " + member.getName() +
                " | Trainer: " + trainer.getName() +
                " | Duration: " + duration + " min";
    }
}
