package model;

public class YogaWorkout extends WorkoutSession {

    private boolean meditation;

    public YogaWorkout(int id, Member m, Trainer t, int d, boolean meditation) {
        super(id, m, t, d);
        this.meditation = meditation;
    }

    @Override
    public void start() {
        System.out.println("Yoga session started. Meditation: " + meditation);
    }

    @Override
    public String getType() {
        return "Yoga";
    }
}
