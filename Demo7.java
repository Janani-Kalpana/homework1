import java.util.Scanner;

public class Demo7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().strip().toUpperCase();
        if (name.isBlank()) {
            System.out.println("\u001B[1;31mInvalid name.\u001B[0m");
            System.exit(1);
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age < 10 && age > 18) {
            System.out.println("\u001B[1;31mInvalid age.\u001B[0m");
            System.exit(1);
        }

        scanner.nextLine(); // Consume the newline character after the integer input

      

        
        System.out.print("Enter subject1 :" );
        String subject1 = scanner.nextLine().strip().toUpperCase();

        // Validate subject name
        if (subject1.isBlank()) {
            System.err.println("\u001B[1;31mInvalid subject.\u001B[0m");
            System.exit(1);
        }

        // Validate subject format
        if (!subject1.matches("SE-\\d{1,3}")) {
            System.err.println("\u001B[1;31mInvalid subject format.\u001B[0m");
            System.exit(1);
        }

        // Validate duplicate subjects
           
        if (subject1.equals(subject1)) {
            System.err.println("\u001B[1;31mSubject names cannot be the same.\u001B[0m");
            System.exit(1);
        }
            

        

        System.out.print("Enter your marks for subject1:" );
        float mark1 = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character after the float input

        // Validate marks
        if (mark1 < 0 || mark1 > 100) {
            System.err.println("\u001B[1;31mInvalid marks.\u001B[0m");
            System.exit(1);
            
        //subject2
        System.out.print("Enter subject1 :" );
        String subject2 = scanner.nextLine().strip().toUpperCase();

        // Validate subject name
        if (subject2.isBlank()) {
            System.err.println("\u001B[1;31mInvalid subject.\u001B[0m");
            System.exit(1);
        }

        // Validate subject format
        if (!subject2.matches("SE-\\d{1,3}")) {
            System.err.println("\u001B[1;31mInvalid subject format.\u001B[0m");
            System.exit(1);
        }

        // Validate duplicate subjects
           
        if (subject2.equals(subject1)) {
            System.err.println("\u001B[1;31mSubject names cannot be the same.\u001B[0m");
            System.exit(1);
        }
            

        

        System.out.print("Enter your marks for subject2:" );
        float mark2 = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character after the float input

        // Validate marks
        if (mark2 < 0 || mark2 > 100) {
            System.err.println("\u001B[1;31mInvalid marks.\u001B[0m");
            System.exit(1);

        }
        //Subject3
        System.out.print("Enter subject1 :" );
        String subject3= scanner.nextLine().strip().toUpperCase();

        // Validate subject name
        if (subject3.isBlank()) {
            System.err.println("\u001B[1;31mInvalid subject.\u001B[0m");
            System.exit(1);
        }

        // Validate subject format
        if (!subject3.matches("SE-\\d{1,3}")) {
            System.err.println("\u001B[1;31mInvalid subject format.\u001B[0m");
            System.exit(1);
        }

        // Validate duplicate subjects
           
        if (subject3.equals(subject1)) {
            System.err.println("\u001B[1;31mSubject names cannot be the same.\u001B[0m");
            System.exit(1);
        }
            

        

        System.out.print("Enter your marks for subject1:" );
        float mark3 = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character after the float input

        // Validate marks
        if (mark3 < 0 && mark3 > 100) {
            System.err.println("\u001B[1;31mInvalid marks.\u001B[0m");
            System.exit(1);

        // Calculate total and average marks
        float totalMarks = mark1 + mark2 + mark3;
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

        // Display the merged tables
        System.out.println("\n+--------------------------------------+");
        System.out.println("|           Student Information        |");
        System.out.println("+--------------------------------------+");
        System.out.println("| Name: " + name);
        System.out.println("| Age: " + age + " years old");
        System.out.printf("| Total: %.2f\n", totalMarks);
        System.out.printf("| Average: %.2f%%\n", averageMarks);
        System.out.println("| Status: " + statusColor + status + "\u001B[0m");
        System.out.println("+--------------------------------------+");

        // Display the subject information
       
        System.out.println("| Subject |  Marks  |    Status        |");
        System.out.println("+--------------------------------------+");
        for (int i = 0; i < 3; i++) {
            System.out.printf("| %-8s|  %5.1f  | %s%-17s\u001B[0m|\n", subjects[i], marks[i], statusColor, status);
        }
        System.out.println("+--------------------------------------+");
    }


}




