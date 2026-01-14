public class CardioWorkout extends WorkoutSession {

    private int caloriesBurned;

    public CardioWorkout(int id, Member member, Trainer trainer, int duration, int calories) {
        super(id, member, trainer, duration);

        if (calories > 0) {
            this.caloriesBurned = calories;
        } else {
            this.caloriesBurned = 100;
        }
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
