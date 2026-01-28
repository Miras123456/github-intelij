package menu;

import model.*;
import database.MemberDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class GymMenu implements Menu {

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Trainer> trainers = new ArrayList<>();
    private ArrayList<WorkoutSession> sessions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private MemberDAO memberDAO = new MemberDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n========== GYM SYSTEM ==========");
        System.out.println("1. Add Member 💫");
        System.out.println("2. View Members 💫");
        System.out.println("3. Add Trainer 💫");
        System.out.println("4. View Trainers 💫");
        System.out.println("5. Add Workout 💫");
        System.out.println("6. View Workouts 💫");
        System.out.println("0. Exit 💫");
        System.out.print("Enter choice 🛐: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> addMember();
                    case 2 -> viewMembers();
                    case 3 -> addTrainer();
                    case 4 -> viewTrainers();
                    case 5 -> addWorkout();
                    case 6 -> viewWorkouts();
                    case 0 -> running = false;
                    default -> System.out.println("Wrong choice 👎🏿");
                }

            } catch (Exception e) {
                System.out.println("Error ❌: " + e.getMessage());
                sc.nextLine();
            }
        }

        System.out.println("Program finished. Bye 👋🏿");
    }

    private void addMember() {
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

        Member m = new Member(id, name, age, type);
        members.add(m);
        memberDAO.insertMember(m);

        System.out.println("Member added 💫");
    }

    private void viewMembers() {
        memberDAO.getAllMembers();
    }

    private void addTrainer() {
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
        System.out.println("Trainer added 💫");
    }

    private void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers found 👎🏿");
            return;
        }

        System.out.println("\nTRAINERS");
        for (Trainer t : trainers) {
            System.out.println("ID: " + t.getId());
            System.out.println("Name: " + t.getName());
            System.out.println("Experience: " + t.getExperience() + " years");
            System.out.println("Specialization: " + t.getSpecialization());
            System.out.println("------------------");
        }
    }

    private void addWorkout() {
        if (members.isEmpty() || trainers.isEmpty()) {
            System.out.println("Add member and trainer first ⚠️");
            return;
        }

        System.out.println("1. Cardio 🏃");
        System.out.println("2. Strength 🏋️");
        System.out.println("3. Yoga 🧘");

        System.out.print("Choose workout: ");
        int type = sc.nextInt();
        sc.nextLine();

        WorkoutSession w = null;

        if (type == 1) {
            System.out.print("Calories: ");
            int cal = sc.nextInt();
            sc.nextLine();
            w = new CardioWorkout(1, members.get(0), trainers.get(0), 60, cal);
        } else if (type == 2) {
            System.out.print("Weight: ");
            int weight = sc.nextInt();
            sc.nextLine();
            w = new StrengthWorkout(1, members.get(0), trainers.get(0), 60, weight);
        } else if (type == 3) {
            System.out.print("Meditation (true/false): ");
            boolean med = sc.nextBoolean();
            sc.nextLine();
            w = new YogaWorkout(1, members.get(0), trainers.get(0), 60, med);
        }

        sessions.add(w);
        System.out.println("Workout added 💪");
    }

    private void viewWorkouts() {
        if (sessions.isEmpty()) {
            System.out.println("No workouts yet 👎🏿");
            return;
        }

        for (WorkoutSession w : sessions) {
            System.out.println("Type: " + w.getType());
            w.start();
            System.out.println("---------------------");
        }
    }
}
