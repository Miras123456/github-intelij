package model;

public class CardioWorkout extends WorkoutSession {

    private int calories;

    public CardioWorkout(int id, Member m, Trainer t, int d, int calories) {
        super(id, m, t, d);
        if (calories <= 0)
            throw new IllegalArgumentException("Calories must be positive");
        this.calories = calories;
    }

    @Override
    public void start() {
        System.out.println("Cardio workout started! Burning " + calories + " calories.");
    }

    @Override
    public String getType() {
        return "Cardio";
    }
}
