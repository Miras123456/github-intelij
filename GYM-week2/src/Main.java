import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainer> trainers = new ArrayList<>();
    private static ArrayList<WorkoutSession> sessions = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n========== GYM SYSTEM ==========");
            System.out.println("1. Add Member💫");
            System.out.println("2. View All Members💫");
            System.out.println("3. Add Trainer💫");
            System.out.println("4. View All Trainers💫");
            System.out.println("5. Add Workout Session💫");
            System.out.println("6. View Workout Sessions💫");
            System.out.println("0. Exit💫");
            System.out.print("Enter choice🛐: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addMember();
            } else if (choice == 2) {
                viewMembers();
            } else if (choice == 3) {
                addTrainer();
            } else if (choice == 4) {
                viewTrainers();
            } else if (choice == 5) {
                addWorkoutSession();
            } else if (choice == 6) {
                viewWorkoutSessions();
            } else if (choice == 0) {
                running = false;
            } else {
                System.out.println("Wrong choice👎🏿.");
            }
        }

        scanner.close();
        System.out.println("Program finished. Bye 👋🏿.");
    }

    // there are members
    private static void addMember() {
        System.out.print("Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Membership type: ");
        String type = scanner.nextLine();

        members.add(new Member(id, name, age, type));
        System.out.println("Member added.");
    }

    private static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found👎🏿.");
            return;
        }

        System.out.println("\nMEMBERS");
        for (Member m : members) {
            System.out.println("ID: " + m.getMemberId());
            System.out.println("Name: " + m.getName());
            System.out.println("Age: " + m.getAge());
            System.out.println("Membership: " + m.getMembershipType());
            System.out.println("Active: " + (m.isActive() ? "Yes ✅" : "No ❌"));
            System.out.println("-----------------");
        }
    }

    // there are trainers
    private static void addTrainer() {
        System.out.print("Trainer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Experience (years): ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        trainers.add(new Trainer(id, name, exp, spec));
        System.out.println("Trainer added.");
    }

    private static void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers found👎🏿.");
            return;
        }

        System.out.println("\nTRAINERS");
        for (Trainer t : trainers) {
            System.out.println("ID: " + t.getTrainerId());
            System.out.println("Name: " + t.getName());
            System.out.println("Experience: " + t.getExperience() + " years");
            System.out.println("Specialization: " + t.getSpecialization());
            System.out.println("Experienced: " + (t.isExperienced() ? "Yes ✅" : "No ❌"));
            System.out.println("Can teach: " + (t.canTeach() ? "Yes ✅" : "No ❌"));
            System.out.println("------------------");
        }
    }

    // there are workout sessions
    private static void addWorkoutSession() {
        System.out.print("Session ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Member name: ");
        String memberName = scanner.nextLine();

        System.out.print("Trainer name: ");
        String trainerName = scanner.nextLine();

        System.out.print("Duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        sessions.add(new WorkoutSession(id, memberName, trainerName, duration));
        System.out.println("Workout session added.");
    }

    private static void viewWorkoutSessions() {
        if (sessions.isEmpty()) {
            System.out.println("No workout sessions found👎🏿.");
            return;
        }

        System.out.println("\nWORKOUT SESSIONS");
        for (WorkoutSession s : sessions) {
            System.out.println("Session ID: " + s.getSessionId());
            System.out.println("Member: " + s.getMemberName());
            System.out.println("Trainer: " + s.getTrainerName());
            System.out.println("Duration: " + s.getDuration() + " minutes");
            System.out.println("-------------------------");
        }
    }
}
