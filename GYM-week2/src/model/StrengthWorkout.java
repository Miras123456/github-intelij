package model;

public class StrengthWorkout extends WorkoutSession {

    private int weight;

    public StrengthWorkout(int id, Member m, Trainer t, int d, int weight) {
        super(id, m, t, d);
        this.weight = weight;
    }

    @Override
    public void start() {
        System.out.println("Strength workout started! Lifting " + weight + "kg.");
    }

    @Override
    public String getType() {
        return "Strength";
    }
}
