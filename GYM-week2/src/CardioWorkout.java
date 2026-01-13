public class CardioWorkout extends WorkoutSession {

    private int caloriesBurned;

    public CardioWorkout(int id, Member member, Trainer trainer, int duration, int calories) {
        super(id, member, trainer, duration);
        this.caloriesBurned = calories;
    }

    @Override
    public void start() {
        System.out.println("Cardio workout started. Burning calories!");
    }

    @Override
    public String getType() {
        return "Cardio Workout";
    }
}
