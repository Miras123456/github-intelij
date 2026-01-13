public class WorkoutSession {
    protected int sessionId;
    protected Member member;
    protected Trainer trainer;
    protected int duration;

    public WorkoutSession(int sessionId, Member member, Trainer trainer, int duration) {
        this.sessionId = sessionId;
        this.member = member;
        this.trainer = trainer;
        this.duration = duration;
    }

    public void start() {
        System.out.println("Workout session started for " + member.getName());
    }

    public String getType() {
        return "General Workout";
    }

    @Override
    public String toString() {
        return "[" + getType() + "] Session " + sessionId +
                " | Member: " + member.getName() +
                " | Trainer: " + trainer.getName() +
                " | Duration: " + duration + " min";
    }
}
