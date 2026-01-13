public class StrengthWorkout extends WorkoutSession {

    private int weightUsed;

    public StrengthWorkout(int id, Member member, Trainer trainer, int duration, int weight) {
        super(id, member, trainer, duration);
        this.weightUsed = weight;
    }

    @Override
    public void start() {
        System.out.println("Strength workout started. Lifting heavy!");
    }

    @Override
    public String getType() {
        return "Strength Workout";
    }
}
