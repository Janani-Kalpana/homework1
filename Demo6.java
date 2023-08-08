import java.util.Scanner;

public class Demo6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().strip().toUpperCase();
        if (name.isBlank()) {
            System.err.println("\u001B[1;31mInvalid name.\u001B[0m");
            System.exit(1);
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age < 10 || age > 100) {
            System.err.println("\u001B[1;31mInvalid age.\u001B[0m");
            System.exit(1);
        }

        scanner.nextLine(); // Consume the newline character after the integer input

        String[] subjects = new String[3];
        float[] marks = new float[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your subject " + (i + 1) + " (SE-number format): ");
            String subject = scanner.nextLine().strip().toUpperCase();

            // Validate subject name
            if (subject.isBlank()) {
                System.err.println("\u001B[1;31mInvalid subject.\u001B[0m");
                System.exit(1);
            }

            // Validate subject format
            if (!subject.matches("SE-\\d{1,3}")) {
                System.err.println("\u001B[1;31mInvalid subject format.\u001B[0m");
                System.exit(1);
            }

            // Validate duplicate subjects
            for (int j = 0; j < i; j++) {
                if (subject.equals(subjects[j])) {
                    System.err.println("\u001B[1;31mSubject names cannot be the same.\u001B[0m");
                    System.exit(1);
                }
            }

            subjects[i] = subject;

            System.out.print("Enter your marks for subject " + (i + 1) + ": ");
            float mark = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline character after the float input

            // Validate marks
            if (mark < 0 || mark > 100) {
                System.err.println("\u001B[1;31mInvalid marks.\u001B[0m");
                System.exit(1);
            }

            marks[i] = mark;
        }

        // Calculate total and average marks
        float totalMarks = marks[0] + marks[1] + marks[2];
        float averageMarks = totalMarks / 3;

        // Determine the status based on the average
        String status;
        String statusColor;
        if (averageMarks > 75) {
            status = "Credit Pass";
            statusColor = "\u001B[1;32m"; // Green color
        } else if (averageMarks > 55) {
            status = "Pass";
            statusColor = "\u001B[1;34m"; // Blue color
        } else {
            status = "Fail";
            statusColor = "\u001B[1;31m"; // Red color
        }

        // Find the length of the longest line in the table
        int longestLineLength = Math.max(
            Math.max(name.length() + 10, String.valueOf(age).length() + 10),
            Math.max("Total: ".length() + 6, "Average: ".length() + 9)
        );

        // Display the merged tables
        System.out.println("\n+" + "-".repeat(longestLineLength) + "+");
        System.out.printf("|%-" + (longestLineLength - 2) + "s|\n", "Student Information");
        System.out.println("+" + "-".repeat(longestLineLength) + "+");
        System.out.printf("| Name: %" + (longestLineLength - 12) + "s |\n", name);
        System.out.printf("| Age: %" + (longestLineLength - 11) + "d |\n", age);
        System.out.printf("| Total: %." + (longestLineLength - 9) + "f |\n", totalMarks);
        System.out.printf("| Average: %." + (longestLineLength - 12) + "f |\n", averageMarks);
        System.out.println("| Status: " + statusColor + status + "\u001B[0m" + " ".repeat(longestLineLength - status.length() - 11) + " |");
        System.out.println("+" + "-".repeat(longestLineLength) + "+");

        // Display the subject information
        System.out.println("\n+" + "-".repeat(32) + "+");
        System.out.printf("|%-" + (longestLineLength - 2) + "s|\n", "Subject Information");
        System.out.println("+" + "-".repeat(32) + "+");
        System.out.println("| Subject |  Marks  |    Status         |");
        System.out.println("+" + "-".repeat(32) + "+");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %-7s|  %5.2f  | %s%-15s\u001B[0m |\n", subjects[i], marks[i], statusColor, status);
        }
        System.out.println("+" + "-".repeat(32) + "+");
    }
}
