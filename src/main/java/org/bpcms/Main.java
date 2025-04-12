package org.bpcms;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PatientManager patient_manager = new PatientManager();
        BookingManager bookingManager = new BookingManager();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        List<Therapist> therapists = new ArrayList<>();

        // Create 4 therapists (same as before)
        therapists.add(new Therapist(1, "Sarah Hussain", "41 Bridle Cl, EN3 6EA", "07905625362",
                Arrays.asList("Neural mobilisation", "Massage", "Pool rehabilitation"),
                createTimetable("Monday", "09:00 - 17:00", "Tuesday", "10:00 - 16:00" )));

        therapists.add(new Therapist(2, "James Bennet", "45 Lynton Garden, EN1 2NF", "0987654321",
                Arrays.asList("Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Tuesday", "10:00 - 18:00", "Thursday", "09:00 - 17:00")));

        therapists.add(new Therapist(3, "Zunaed Ahmed", "78 Forest Road, EN3 3ED", "0172398456",
                Arrays.asList("Massage", "Pool rehabilitation"),
                createTimetable("Monday", "08:00 - 12:00", "Friday", "09:00 - 15:00")));

        therapists.add(new Therapist(4, "Daniel Steven", "321 High Road, EN2 5AL", "0198765432",
                Arrays.asList("Neural mobilisation", "Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Wednesday", "13:00 - 17:00", "Thursday", "08:00 - 14:00")));


        // Menu loop
        while (true) {
            System.out.println("\n--- Therapist Management System ---");
            System.out.println("1. Therapist");
            System.out.println("2. Patient");
            System.out.println("3. Treatment");
            System.out.println("4. Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\n--- Therapist Management  ---");
                        System.out.println("1. View All Therapists");
                        //System.out.println("2. Go Back");
                        System.out.print("Enter your choice: ");


                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice2) {
                            case 1:
                                // View All Therapists
                                for (Therapist t : therapists) {
                                    t.displayInfo();
                                }
                                break;

                            case 2:
                                break;
                        }
                        break;
                    }
                    break;


                case 2:
                    while (true) {
                        System.out.println("\n--- Patient Management ---");
                        System.out.println("1. Add a Patient");
                        System.out.println("2. View all Patients");
                        //System.out.println("3. Go Back");
                        System.out.print("Enter your choice: ");


                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice2) {
                            case 1:
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


                case 3:
                    while (true) {
                        System.out.println("\n--- Treatment ---");
                        System.out.println("1. Add a Treatment");
                        System.out.println("2. Search Treatment");
                        //System.out.println("3. Go Back");
                        System.out.print("Enter your choice: ");


                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (choice2) {
                            case 1:
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

                case 4:
                    System.out.println("\nAvailable Treatments:");
                    List<String> allTreatments = Arrays.asList(
                            "Neural mobilisation",
                            "Acupuncture",
                            "Massage",
                            "Mobilisation of the spine and joints",
                            "Pool rehabilitation"
                    );

                    for (int i = 0; i < allTreatments.size(); i++) {
                        System.out.println((i + 1) + ". " + allTreatments.get(i));
                    }

                    System.out.print("Select a treatment (1-5): ");
                    int treatmentChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (treatmentChoice < 1 || treatmentChoice > allTreatments.size()) {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    String selectedTreatment = allTreatments.get(treatmentChoice - 1);
                    System.out.println("You selected: " + selectedTreatment);

                    // Filter therapists who offer that treatment
                    List<Therapist> filteredTherapists = new ArrayList<>();
                    for (Therapist t : therapists) {
                        if (t.treatmentsOffered.contains(selectedTreatment)) {
                            filteredTherapists.add(t);
                        }
                    }

                    if (filteredTherapists.isEmpty()) {
                        System.out.println("No therapists offer this treatment at the moment.");
                        break;
                    }

                    System.out.println("Available Therapists for " + selectedTreatment + ":");
                    for (Therapist t : filteredTherapists) {
                        System.out.println("  " + t.getName() + " (ID: " + t.getID() + ")");
                    }

                    System.out.print("Enter Therapist ID to book: ");
                    int therapistId = scanner.nextInt();
                    scanner.nextLine();

                    Therapist selected = null;
                    for (Therapist t : filteredTherapists) {
                        if (t.getID() == therapistId) {
                            selected = t;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println("Invalid Therapist ID!");
                        break;
                    }

                    System.out.print("Enter your name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter day (e.g., Monday): ");
                    String day = scanner.nextLine();
                    System.out.print("Enter time (e.g., 10:00 - 11:00): ");
                    String time = scanner.nextLine();

                    bookingManager.makeBooking(selected, patientName, day, time);
                    break;



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
    private static Timetable createTimetable(String day1, String time1, String day2, String time2) {
        Timetable t = new Timetable();
        t.setDay(day1, time1);
        t.setDay(day2, time2);

        return t;
    }
}