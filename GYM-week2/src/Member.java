public class Member {
    private int memberId;
    private String name;
    private int age;
    private String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        this.setMemberId(memberId);
        this.setName(name);
        this.setAge(age);
        this.setMembershipType(membershipType);
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        if (memberId > 0) {
            this.memberId = memberId;
        } else {
            System.out.println("Member ID must be positive. Set to 1.");
            this.memberId = 1;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Set to 0.");
            this.age = 0;
        }
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        if (membershipType != null && !membershipType.trim().isEmpty()) {
            this.membershipType = membershipType;
        } else {
            System.out.println("Membership type not provided. Set to 'Inactive'.");
            this.membershipType = "Inactive";
        }
    }

    public boolean isActive() {
        return this.membershipType.equalsIgnoreCase("Active");
    }

    public void upgrade() {
        if (this.membershipType.equalsIgnoreCase("Inactive")
                || this.membershipType.equalsIgnoreCase("Basic")) {
            this.membershipType = "Active";
        } else if (this.membershipType.equalsIgnoreCase("Active")) {
            this.membershipType = "Premium";
        } else {
            System.out.println(this.name + " is already Premium");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + this.memberId +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", membershipType='" + this.membershipType + '\'' +
                '}';
    }
}
