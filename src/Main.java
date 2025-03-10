import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a TherapistManager instance
        TherapistManager manager = new TherapistManager();
        PatientManager patient_manager = new PatientManager();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Menu loop
        while (true) {
            System.out.println("\n--- Therapist Management System ---");
            System.out.println("1. Add People");
            System.out.println("2. View People");
            System.out.println("3. Treatment");
            System.out.println("4. Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\n--- Add People ---");
                        System.out.println("1. Add a Therapist");
                        System.out.println("2. Add a Patient");
                        System.out.print("Enter your choice: ");
                        //System.out.println("3. Go Back");

                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice2) {
                            case 1:
                                // Add a Therapist
                                System.out.println("\nEnter Therapist Details:");
                                System.out.print("Unique ID: ");
                                int uniqueId = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                System.out.print("Name: ");
                                String name = scanner.nextLine();

                                System.out.print("Address: ");
                                String address = scanner.nextLine();

                                System.out.print("Number: ");
                                String number = scanner.nextLine();

                                System.out.print("Email: ");
                                String email = scanner.nextLine();

                                // Create a Therapist object and add it to the list
                                manager.addTherapist(new Therapist(uniqueId, name, address, number, email));
                                System.out.println("Therapist added successfully!");
                                break;

                            case 2:
                                //Add a Patient
                                System.out.println("\nEnter Patient Details:");
                                System.out.print("Patient ID: ");
                                int patient_id = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character

                                System.out.print("Name: ");
                                String patient_name = scanner.nextLine();

                                System.out.print("Address: ");
                                String patient_address = scanner.nextLine();

                                System.out.print("Number: ");
                                String patient_number = scanner.nextLine();

                                System.out.print("Email: ");
                                String patient_email = scanner.nextLine();

                                // Create a Patient object and add it to the list
                                patient_manager.addPatient(new Patient(patient_id, patient_name, patient_address, patient_number, patient_email));
                                System.out.println("Patient added successfully!");
                                break;

                            case 3:
                                break;
                        }
                        break;
                    }
                    break;


                case 2:
                    while (true) {
                        System.out.println("\n--- View People ---");
                        System.out.println("1. View all Therapists");
                        System.out.println("2. View all Patients");
                        System.out.print("Enter your choice: ");
                        //System.out.println("3. Go Back");

                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice2) {
                            case 1:
                                // View All Therapists
                                System.out.println("\nAll Therapists:");
                                for (Therapist therapist : manager.getAllTherapists()) {
                                    System.out.println(therapist);
                                }
                                break;


                            case 2:
                                // View All Patient
                                System.out.println("\nAll Patients:");
                                for (Patient patient : patient_manager.getAllPatients()) {
                                    System.out.println(patient);
                                }
                                break;

                        }
                        break;

                    }break;




                case 5:
                    // Exit the program
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}