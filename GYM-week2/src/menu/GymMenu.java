package menu;

import model.*;
import database.MemberDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymMenu implements Menu {

    private Scanner sc = new Scanner(System.in);
    private MemberDAO dao = new MemberDAO();

    private ArrayList<Trainer> trainers = new ArrayList<>();
    private ArrayList<WorkoutSession> sessions = new ArrayList<>();

    @Override
    public void displayMenu() {
        System.out.println("\n========== GYM SYSTEM ==========");
        System.out.println("1. Add Member💫");
        System.out.println("2. View All Members💫");
        System.out.println("3. Update Member💫");
        System.out.println("4. Delete Member💫");
        System.out.println("5. Search Member by Name💫");
        System.out.println("6. Search Member by Age Range💫");
        System.out.println("7. Members with Age >= X💫");
        System.out.println("8. Add Trainer💫");
        System.out.println("9. View Trainers💫");
        System.out.println("10. Add Workout💫");
        System.out.println("11. View Workouts💫");
        System.out.println("0. Exit👋🏿");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addMember();
                case 2 -> viewAllMembers();
                case 3 -> updateMember();
                case 4 -> deleteMemberSafe();
                case 5 -> searchByName();
                case 6 -> searchByAgeRange();
                case 7 -> searchByMinAge();
                case 8 -> addTrainer();
                case 9 -> viewTrainers();
                case 10 -> addWorkout();
                case 11 -> viewWorkouts();
                case 12 -> polymorphismDemo();
                case 0 -> { return; }
                default -> System.out.println("Invalid option❌");
            }
        }
    }


    private void addMember() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Membership type: ");
        String type = sc.nextLine();

        boolean success = dao.insertMember(new Member(1, name, age, type));
        System.out.println(success ? "Added ✅" : "Failed ❌");
    }

    private void viewAllMembers() {
        List<Member> list = dao.getAllMembers();
        list.forEach(m -> System.out.println(m.getId() + " | " + m.getName() + " | " + m.getAge() + " | " + m.getMembershipType()));
    }

    private void updateMember() {
        System.out.print("Member ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("New membership type: ");
        String type = sc.nextLine();

        System.out.println(dao.updateMember(id, type) ? "Updated ✅" : "Not found ❌");
    }

    private void deleteMemberSafe() {
        System.out.print("Enter Member ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        Member m = dao.getMemberById(id);
        if (m == null) {
            System.out.println("Member not found ❌");
            return;
        }

        System.out.println("Deleting: " + m.getName() + " | Age: " + m.getAge());
        System.out.print("Are you sure? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            System.out.println(dao.deleteMember(id) ? "Deleted 🗑️" : "Delete failed ❌");
        } else {
            System.out.println("Cancelled");
        }
    }

    private void searchByName() {
        System.out.print("Enter name: ");
        dao.searchByName(sc.nextLine())
                .forEach(m -> System.out.println(m.getId() + " | " + m.getName()));
    }

    private void searchByAgeRange() {
        System.out.print("Min age: ");
        int min = Integer.parseInt(sc.nextLine());
        System.out.print("Max age: ");
        int max = Integer.parseInt(sc.nextLine());

        dao.searchByAgeRange(min, max)
                .forEach(m -> System.out.println(m.getId() + " | " + m.getName() + " | " + m.getAge()));
    }

    private void searchByMinAge() {
        System.out.print("Min age: ");
        int min = Integer.parseInt(sc.nextLine());

        dao.searchByMinAge(min)
                .forEach(m -> System.out.println(m.getId() + " | " + m.getName() + " | " + m.getAge()));
    }


    private void addTrainer() {
        System.out.print("Trainer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Experience: ");
        int exp = Integer.parseInt(sc.nextLine());
        System.out.print("Specialization: ");
        String spec = sc.nextLine();

        trainers.add(new Trainer(id, name, exp, spec));
        System.out.println("Trainer added 💪");
    }

    private void viewTrainers() {
        if (trainers.isEmpty()) {
            System.out.println("No trainers found");
            return;
        }
        trainers.forEach(t -> System.out.println(t.getId() + " | " + t.getName() + " | " + t.getExperience() + " yrs | " + t.getSpecialization()));
    }


    private void addWorkout() {
        if (trainers.isEmpty()) {
            System.out.println("Add a trainer first ⚠️");
            return;
        }

        System.out.println("1. Cardio\n2. Strength\n3. Yoga");
        int type = Integer.parseInt(sc.nextLine());

        WorkoutSession w = null;

        if (type == 1) w = new CardioWorkout(1, null, trainers.get(0), 60, 300);
        if (type == 2) w = new StrengthWorkout(1, null, trainers.get(0), 60, 80);
        if (type == 3) w = new YogaWorkout(1, null, trainers.get(0), 60, true);

        sessions.add(w);
        System.out.println("Workout added 🏋️");
    }

    private void viewWorkouts() {
        if (sessions.isEmpty()) {
            System.out.println("No workouts yet");
            return;
        }
        sessions.forEach(w -> {
            System.out.println("Type: " + w.getType());
            w.start();
        });
    }

    private void polymorphismDemo() {
        System.out.println("Different workout types behave differently 💪");
    }
}
