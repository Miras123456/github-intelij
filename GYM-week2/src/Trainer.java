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

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public boolean isExperienced() { // if trained has more than 4 years experience, he will be experienced
        return experience >= 5;
    }

    public boolean canTeach() { // if trained has more than 1 year experience< he can teach members
        return experience >= 2;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}