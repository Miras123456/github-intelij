package model;

public abstract class WorkoutSession {

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

    public abstract void start();
    public abstract String getType();

    public void setSessionId(int sessionId) {
        if (sessionId <= 0)
            throw new IllegalArgumentException("Session ID must be positive");
        this.sessionId = sessionId;
    }

    public void setMember(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member cannot be null");
        this.member = member;
    }

    public void setTrainer(Trainer trainer) {
        if (trainer == null)
            throw new IllegalArgumentException("Trainer cannot be null");
        this.trainer = trainer;
    }

    public void setDuration(int duration) {
        if (duration <= 0)
            throw new IllegalArgumentException("Duration must be positive");
        this.duration = duration;
    }
}
