package model;

public class Member {

    private int id;
    private String name;
    private int age;
    private String membershipType;

    public Member(int id, String name, int age, String membershipType) {
        setId(id);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMembershipType() { return membershipType; }

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

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public void setMembershipType(String type) {
        if (type == null || type.isEmpty())
            throw new IllegalArgumentException("Membership required");
        this.membershipType = type;
    }
}
