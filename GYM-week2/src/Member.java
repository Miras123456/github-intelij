public class Member {
    private int memberId;
    private String name;
    private int age;
    private String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isActive() {
        return membershipType.equalsIgnoreCase("Active");
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                " | Name: " + name +
                " | Age: " + age +
                " | Membership: " + membershipType;
    }
}
