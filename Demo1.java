import java.util.Scanner;

public class Demo1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().strip();
        if (name.isBlank()) {
            System.err.println("\u001B[1;31mInvalid name.\u001B[0m");
            System.exit(1);
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age < 10 || age > 18) {
            System.err.println("\u001B[1;31mInvalid age.\u001B[0m");
            System.exit(1);
        }

        scanner.nextLine(); // Consume the newline character after the integer input

        String[] subjects = new String[3];
        float[] marks = new float[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your subject " + (i + 1) + " (SE-number format): ");
            String subject = scanner.nextLine().strip();

            // Validate subject name
            if (subject.isBlank()) {
                System.err.println("\u001B[1;31mInvalid subject.\u001B[0m");
                System.exit(1);
            }

            // Validate subject format
            if (!subject.startsWith("SE-") || !subject.substring(3).chars().allMatch(Character::isDigit)) {
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
            if (mark < 0) {
                System.err.println("\u001B[1;31mInvalid marks.\u001B[0m");
                System.exit(1);
            }

            marks[i] = mark;
        }

        // Display the collected data
        System.out.println("\nName: " + name);
        System.out.println("Age: " + age);
        for (int i = 0; i < 3; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subjects[i]);
            System.out.println("Marks " + (i + 1) + ": " + marks[i]);
        }
    }
}
