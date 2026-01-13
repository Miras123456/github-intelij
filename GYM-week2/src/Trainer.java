public class Trainer {
    private int trainerId;
    private String name;
    private int experience;
    private String specialization;

    public Trainer(int trainerId, String name, int experience, String specialization) {
        this.trainerId = trainerId;
        this.name = name;
        this.experience = experience;
        this.specialization = specialization;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isExperienced() {
        return experience >= 5;
    }

    @Override
    public String toString() {
        return "Trainer ID: " + trainerId +
                " | Name: " + name +
                " | Experience: " + experience + " years" +
                " | Specialization: " + specialization;
    }
}
