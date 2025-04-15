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
                createTimetable("Monday", "09:00", "12:00", "Wednesday", "10:00", "12:00")));


        therapists.add(new Therapist(2, "James Bennet", "45 Lynton Garden, EN1 2NF", "0987654321",
                Arrays.asList("Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Tuesday", "10:00", "14:00", "Thursday", "09:00", "15:00")));

        therapists.add(new Therapist(3, "Zunaed Ahmed", "78 Forest Road, EN3 3ED", "0172398456",
                Arrays.asList("Massage", "Pool rehabilitation"),
                createTimetable("Monday", "08:00", "12:00", "Friday", "09:00", "15:00")));

        therapists.add(new Therapist(4, "Daniel Steven", "321 High Road, EN2 5AL", "0198765432",
                Arrays.asList("Neural mobilisation", "Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Wednesday", "13:00", "17:00", "Thursday", "08:00", "14:00")));


        // Menu loop
        while (true) {
            System.out.println("\n--- Therapist Management System ---");
            System.out.println("1. Therapist");
            System.out.println("2. Patient");
            System.out.println("3. Appointment");
            System.out.println("4. See all Appointments");
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

                    Map<String, List<String>> availableSlots = selected.getAvailableSlots();
                    if (availableSlots.isEmpty()) {
                        System.out.println("No available time slots for this therapist.");
                        break;
                    }

                    System.out.println("\nAvailable Appointment Slots:");
                    int count = 1;
                    Map<Integer, String[]> optionMap = new HashMap<>();
                    for (String day : availableSlots.keySet()) {
                        for (String time : availableSlots.get(day)) {
                            System.out.println(count + ". " + day + " at " + time);
                            optionMap.put(count, new String[]{day, time});
                            count++;
                        }
                    }

                    System.out.print("Select a slot (1-" + (count - 1) + "): ");
                    int slotChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (!optionMap.containsKey(slotChoice)) {
                        System.out.println("Invalid slot selected.");
                        break;
                    }

                    String[] chosenSlot = optionMap.get(slotChoice);
                    String selectedDay = chosenSlot[0];
                    String selectedTime = chosenSlot[1];

                    System.out.print("Enter your name: ");
                    String patientName = scanner.nextLine();

                    if (selected.book(selectedDay, selectedTime)) {
                        bookingManager.makeBooking(selected, patientName, selectedDay, selectedTime);
                    } else {
                        System.out.println("Slot already booked. Try another.");
                    }
                    break;


                case 4:
                    bookingManager.showAllBookings();
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
//    private static Timetable createTimetable(String day1, String time1, String day2, String time2) {
//        Timetable t = new Timetable();
//        t.setDay(day1, time1);
//        t.setDay(day2, time2);
//
//        return t;
//    }
    public static Timetable createTimetable(String... args) {
        Timetable timetable = new Timetable();
        for (int i = 0; i < args.length; i += 3) {
            timetable.addSlot(args[i], args[i+1], args[i+2]);
        }
        return timetable;
    }

}