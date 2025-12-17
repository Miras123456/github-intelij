public class Member {
    private int memberid;
    private String name;
    private int age;
    private String membershipType;

    public Member(int memberid, String name, int age, String membershipType) {
        this.memberid = memberid;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    public int getMemberid() {
        return memberid;
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

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isActive() {
        return this.membershipType.equals("Active");
    }

    public void upgrade() { // Upgrade membership: Inactive to Active, Basic to Active, Active to Premium, Premium to already Premium

        if (this.membershipType.equals("Inactive")) {
            this.membershipType = "Active";
        } else if (this.membershipType.equals("Active")) {
            this.membershipType = "Premium";
        } else if (this.membershipType.equals("Basic")) {
            this.membershipType = "Active";
        } else if (this.membershipType.equals("Premium")) {
            System.out.println(name + "Already Premium member");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberid=" + memberid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", membershipType='" + membershipType + '\'' +
                '}';
    }
}
