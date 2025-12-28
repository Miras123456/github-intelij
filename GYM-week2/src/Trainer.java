public class Trainer {
    private int trainerId;
    private String name;
    private int experience;
    private String specialization;

    public Trainer(int trainerId, String name, int experience, String specialization) {
        this.setTrainerId(trainerId);
        this.setName(name);
        this.setExperience(experience);
        this.setSpecialization(specialization);
    }

    public int getTrainerId() {
        return this.trainerId;
    }

    public void setTrainerId(int trainerId) {
        if (trainerId > 0) {
            this.trainerId = trainerId;
        } else {
            System.out.println("Trainer ID must be positive. Set to 1.");
            this.trainerId = 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty. Set to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        } else {
            System.out.println("Experience cannot be negative. Set to 0.");
            this.experience = 0;
        }
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Specialization not provided. Set to 'General'.");
            this.specialization = "General";
        }
    }

    public boolean isExperienced() {
        return this.experience >= 5;
    }

    public boolean canTeach() {
        return this.experience >= 2;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + this.trainerId +
                ", name='" + this.name + '\'' +
                ", experience=" + this.experience +
                ", specialization='" + this.specialization + '\'' +
                '}';
    }
}
