public class Main {  // IT-2502 Rinatuly Miras
    public static void main(String[] args) {
        Member member1 = new Member(01, "Birzhan", 18, "Active");
        Trainer trainer1 = new Trainer(01, "Gani", 7, "Fitness");
        WorkoutSession workoutSession1 = new WorkoutSession(01, "Birzhan", "Gani", 500);


        System.out.println(member1.toString());
        System.out.println("Active?" + member1.isActive());

        member1.upgrade();
        System.out.println("After uprgare: " + member1);
        System.out.println("Active? " + member1.isActive());

        System.out.println(trainer1.toString());
        System.out.println("Experienced: " + trainer1.isExperienced());
        System.out.println("Can teach: " + trainer1.canTeach());

        System.out.println(workoutSession1.toString());
        System.out.println(workoutSession1.extend());
        System.out.println(workoutSession1.complete());
    }

}