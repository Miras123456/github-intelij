package model;

public class Trainer {

    private int id;
    private String name;
    private int experience;
    private String specialization;

    public Trainer(int id, String name, int experience, String specialization) {
        setId(id);
        setName(name);
        setExperience(experience);
        setSpecialization(specialization);
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setExperience(int experience) {
        if (experience < 0)
            throw new IllegalArgumentException("Experience cannot be negative");
        this.experience = experience;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isEmpty())
            throw new IllegalArgumentException("Specialization required");
        this.specialization = specialization;
    }
}
