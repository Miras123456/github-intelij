public class Member {
    private int memberId;
    private String name;
    private int age;
    private String membershipType;

    public Member(int memberId, String name, int age, String membershipType) {
        setMemberId(memberId);
        setName(name);
        setAge(age);
        setMembershipType(membershipType);
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        if (memberId > 0) {
            this.memberId = memberId;
        } else {
            System.out.println("Invalid ID. Set to 1.");
            this.memberId = 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Set to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Set to 0.");
            this.age = 0;
        }
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        if (membershipType != null && !membershipType.trim().isEmpty()) {
            this.membershipType = membershipType;
        } else {
            System.out.println("Invalid membership. Set to Inactive.");
            this.membershipType = "Inactive";
        }
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId +
                " | Name: " + name +
                " | Age: " + age +
                " | Membership: " + membershipType;
    }
}
