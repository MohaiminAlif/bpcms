package org.bpcms;
import java.util.Scanner;
import java.util.*;

public class Main {
    private static Patient selectedPatient;

    public static void main(String[] args) {

        BookingManager bookingManager = new BookingManager();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        List<Therapist> therapists = new ArrayList<>();


        // Create 4 therapists (same as before)
        therapists.add(new Therapist(1, "Sarah Hussain", "41 Bridle Cl, EN3 6EA", "07905625362",
                Arrays.asList("Neural mobilisation", "Massage", "Pool rehabilitation"),
                createTimetable("Monday", "09:00", "12:00", "Wednesday", "10:00", "14:00")));


        therapists.add(new Therapist(2, "James Bennet", "45 Lynton Garden, EN1 2NF", "0987654321",
                Arrays.asList("Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Tuesday", "10:00", "14:00", "Thursday", "09:00", "15:00")));

        therapists.add(new Therapist(3, "Zunaed Ahmed", "78 Forest Road, EN3 3ED", "0172398456",
                Arrays.asList("Massage", "Pool rehabilitation"),
                createTimetable("Monday", "08:00", "12:00", "Friday", "09:00", "15:00")));

        therapists.add(new Therapist(4, "Daniel Steven", "321 High Road, EN2 5AL", "0198765432",
                Arrays.asList("Neural mobilisation", "Acupuncture", "Mobilisation of the spine and joints"),
                createTimetable("Wednesday", "13:00", "17:00", "Thursday", "08:00", "14:00")));

        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Nusrat Maliha", "55 Kingsley Ave", "01234 567890"));
        patients.add(new Patient("Ismatara Begum", "56 Kingsley Ave", "01235 678901"));
        patients.add(new Patient("Kalam Azad", "29 Davey Cl", "01236 789012"));
        patients.add(new Patient("Yasin Miah", "41 Bridle Cl", "01237 890123"));
        patients.add(new Patient("Robert Walker", "654 Purple Rd", "01238 901234"));
        patients.add(new Patient("Mohsin Miah", "26 kestrel Court", "01239 012345"));
        patients.add(new Patient("Harry Taylor", "147 Pink Ave", "01240 123456"));
        patients.add(new Patient("Rizwan Azad", "258 Lime Rd", "01241 234567"));
        patients.add(new Patient("Chris Evans", "369 Bishop Cl", "01242 345678"));
        patients.add(new Patient("Abid Hussain", "74 Coral Rd", "01243 456789"));


        // Menu loop
        while (true) {
            System.out.println("\n--- Therapist Management System ---");
            System.out.println("1. Therapist");
            System.out.println("2. Patient");
            System.out.println("3. Appointments");
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
                        System.out.println("2. Go Back");
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
                        }break;
                    }break;


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

                                System.out.print("Name: ");
                                String patieName = scanner.nextLine();

                                System.out.print("Address: ");
                                String patientAddress = scanner.nextLine();

                                System.out.print("Number: ");
                                String patientNumber = scanner.nextLine();

                                // Create a Patient object and add it to the list
                                patients.add(new Patient(patieName, patientAddress, patientNumber));
                                System.out.println("Patient Added successfully, Patient ID is " + patients.getLast().getID());

                                break;


                            case 2:
                                // View All Patient
                                System.out.println("\n=== Patient List ===");
                                for (Patient p : patients) {
                                    System.out.println(p);
                                }
                                break;
                       }
                        break;

                    }
                    break;


                case 3:
                    while (true) {
                        System.out.println("\n--- Booking Management ---");
                        System.out.println("1. Make a Booking");
                        System.out.println("2. View all Appointments");
                        System.out.println("3. Appointment Status");
                        System.out.println("4. Go Back");

                        System.out.print("Enter your choice: ");
                        int choice3 = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (choice3) {
                            case 1:
                                System.out.println("\n=== Make a Booking ===");
                                System.out.println("Enter your Patient ID:");
                                int patientId = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                               
                                for (Patient p : patients) {
                                    if (p.getID() == patientId) {
                                        selectedPatient = p;
                                        break;
                                    }
                                }

                                if (selectedPatient == null) {
                                    System.out.println("No Patient with this ID found.");
                                    break;
                                }


                                System.out.println("Welcome, " + selectedPatient.getName() + "!\n");

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
                                //
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
                                String day = chosenSlot[0];
                                String time = chosenSlot[1];

                                String patientName = selectedPatient.getName();
                                Integer patientID = selectedPatient.getID();
                                String status = "booked";


                                if (selected.book(day, time)) {
                                    bookingManager.makeBooking(selected, patientName, patientID, day, time, status);
                                } else {
                                    System.out.println("Slot already booked. Try another.");
                                }break;


                            case 2:
                                bookingManager.showAllBookings();
                                break;


                            case 3:
                                System.out.print("Enter your Patient ID: ");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();

                                Patient bookingPatient = null;
                                for (Patient p : patients) {
                                    if (p.getID() == updateId) {
                                        bookingPatient = p;
                                        break;
                                    }
                                }

                                if (bookingPatient == null) {
                                    System.out.println("Patient not found.");
                                    break;
                                }

                                List<Booking> patientBookings = bookingManager.getBookingsByPatient(bookingPatient.getName());

                                if (patientBookings.isEmpty()) {
                                    System.out.println("No bookings found for " + bookingPatient.getName());
                                    break;
                                }

                                System.out.println("\nYour Bookings:");
                                for (int i = 0; i < patientBookings.size(); i++) {
                                    System.out.println((i + 1) + ". " + patientBookings.get(i).getSummary());
                                }

                                System.out.print("Select a booking to update: ");
                                int bookingIndex = scanner.nextInt() - 1;
                                scanner.nextLine();

                                if (bookingIndex < 0 || bookingIndex >= patientBookings.size()) {
                                    System.out.println("Invalid selection.");
                                    break;
                                }

                                Booking selectedBooking = patientBookings.get(bookingIndex);

                                System.out.println("Current status: " + selectedBooking.getStatus());
                                System.out.println("Enter new status (Booked / Cancelled / Visited): ");
                                String newStatus = scanner.nextLine();

                                if (newStatus.equalsIgnoreCase("Booked") ||
                                        newStatus.equalsIgnoreCase("Cancelled") ||
                                        newStatus.equalsIgnoreCase("Visited")) {
                                    selectedBooking.setStatus(newStatus);
                                    System.out.println("Booking status updated successfully.");
                                } else {
                                    System.out.println("Invalid status input.");
                                }
                                break;
                            case 4:
                                break;
                        }break;

                    }break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting the program. Thank You!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Timetable createTimetable(String... args) {
        Timetable timetable = new Timetable();
        for (int i = 0; i < args.length; i += 3) {
            timetable.addSlot(args[i], args[i+1], args[i+2]);
        }
        return timetable;
    }

}