import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Trainer> trainers = new ArrayList<>();
    static ArrayList<WorkoutSession> sessions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n====== GYM SYSTEM ======");
            System.out.println("1. Add Member💫");
            System.out.println("2. Add Trainer💫");
            System.out.println("3. Add Workout Session💫");
            System.out.println("4. View All Members💫");
            System.out.println("5. View All Trainers💫");
            System.out.println("6. View All Workouts💫");
            System.out.println("0. Exit👋🏿");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addMember();
                case 2 -> addTrainer();
                case 3 -> addWorkout();
                case 4 -> viewMembers();
                case 5 -> viewTrainers();
                case 6 -> viewWorkouts();
                case 0 -> running = false;
                default -> System.out.println("Wrong choice!👎🏿");
            }
        }

        System.out.println("Program finished. Bye bye✅");
    }

    //member
    static void addMember() {
        System.out.print("Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Membership type: ");
        String type = sc.nextLine();

        members.add(new Member(id, name, age, type));
        System.out.println("Member added!✅");
    }

    static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members.❌");
            return;
        }

        for (Member m : members) {
            System.out.println(m);
        }
    }

    //trainer
    static void addTrainer() {
        System.out.print("Trainer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Experience (years): ");
        int exp = sc.nextInt();
        sc.nextLine();

        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        trainers.add(new Trainer(id, name, exp, spec));
        System.out.println("Trainer added!✅");
    }

    static void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers.❌");
            return;
        }

        for (Trainer t : trainers) {
            System.out.println(t);
        }
    }

    //workout
    static void addWorkout() {

        if (members.isEmpty() || trainers.isEmpty()) {
            System.out.println("Add members and trainers first!");
            return;
        }

        System.out.println("Choose workout type:");
        System.out.println("1. Cardio");
        System.out.println("2. Strength");
        System.out.println("3. Yoga");

        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Session ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Member member = members.get(0);
        Trainer trainer = trainers.get(0);

        System.out.print("Duration (minutes): ");
        int duration = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            System.out.print("Calories burned: ");
            int cal = sc.nextInt();
            sc.nextLine();
            sessions.add(new CardioWorkout(id, member, trainer, duration, cal));
        }

        else if (type == 2) {
            System.out.print("Weight used (kg): ");
            int weight = sc.nextInt();
            sc.nextLine();
            sessions.add(new StrengthWorkout(id, member, trainer, duration, weight));
        }

        else if (type == 3) {
            System.out.print("Difficulty level: ");
            String level = sc.nextLine();
            sessions.add(new YogaWorkout(id, member, trainer, duration, level));
        }

        else {
            System.out.println("Wrong type!❌");
            return;
        }

        System.out.println("Workout added!✅");
    }

    static void viewWorkouts() {
        if (sessions.isEmpty()) {
            System.out.println("No workouts.❌");
            return;
        }

        for (WorkoutSession w : sessions) {
            w.start();
            System.out.println(w);
        }
    }
}