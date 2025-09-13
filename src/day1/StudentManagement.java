package day1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Method to add student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();

        students.add(new Student(id, name, grade));
        System.out.println("✅ Student added successfully!\n");
    }

    // Method to remove student by ID
    public static void removeStudent() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        boolean removed = false;
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("❌ Student removed successfully!\n");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("⚠️ Student with ID " + id + " not found.\n");
        }
    }

    // Method to display all students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.\n");
        } else {
            System.out.println("📋 Student List:");
            for (Student s : students) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // Main method with menu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("----- Student Management Menu -----");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: displayStudents(); break;
                case 4: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("⚠️ Invalid choice, try again!\n");
            }
        } while (choice != 4);
    }
}