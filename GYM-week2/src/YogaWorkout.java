public class YogaWorkout extends WorkoutSession {

    private String difficultyLevel;

    public YogaWorkout(int id, Member member, Trainer trainer, int duration, String level) {
        super(id, member, trainer, duration);

        if (level != null && !level.isEmpty()) {
            this.difficultyLevel = level;
        } else {
            this.difficultyLevel = "Beginner";
        }
    }

    @Override
    public void start() {
        System.out.println("Yoga session started. Relax and breathe...");
    }

    @Override
    public String getType() {
        return "Yoga Workout";
    }
}
