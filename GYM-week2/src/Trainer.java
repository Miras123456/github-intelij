public class Trainer {
    private int trainerId;
    private String name;
    private int experience;
    private String specialization;

    public Trainer(int trainerId, String name, int experience, String specialization) {
        setTrainerId(trainerId);
        setName(name);
        setExperience(experience);
        setSpecialization(specialization);
    }

    public void setTrainerId(int trainerId) {
        if (trainerId > 0) {
            this.trainerId = trainerId;
        } else {
            System.out.println("Invalid ID. Set to 1.");
            this.trainerId = 1;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Set to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setExperience(int experience) {
        if (experience >= 0) {
            this.experience = experience;
        } else {
            System.out.println("Invalid experience. Set to 0.");
            this.experience = 0;
        }
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Invalid specialization. Set to 'General'.");
            this.specialization = "General";
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trainer ID: " + trainerId +
                " | Name: " + name +
                " | Experience: " + experience +
                " | Specialization: " + specialization;
    }
}
