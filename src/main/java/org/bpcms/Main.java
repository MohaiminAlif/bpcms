package org.bpcms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;

public class Main {
    private static Patient selectedPatient;

    public static void main(String[] args) {

        BookingManager bookingManager = new BookingManager();

        Scanner scanner = new Scanner(System.in);// Create a Scanner object to read input from the console

        // Create separate timetables for each therapist
        Timetable timetable1 = new Timetable();
        timetable1.addSlot(1, "Monday", "09:00", "12:00");
        timetable1.addSlot(2, "Wednesday", "10:00", "13:00");
        timetable1.addSlot(3, "Monday", "14:00", "18:00");
        timetable1.addSlot(4, "Thursday", "09:00", "12:00");

        Timetable timetable2 = new Timetable();
        timetable2.addSlot(1, "Tuesday", "10:00", "14:00");
        timetable2.addSlot(2, "Thursday", "09:00", "15:00");
        timetable2.addSlot(3, "Monday", "08:00", "12:00");
        timetable2.addSlot(4, "Friday", "09:00", "13:00");

        Timetable timetable3 = new Timetable();
        timetable3.addSlot(1, "Wednesday", "08:00", "12:00");
        timetable3.addSlot(2, "Friday", "09:00", "12:00");
        timetable3.addSlot(3, "Tuesday", "14:00", "18:00");
        timetable3.addSlot(4, "Monday", "10:00", "13:00");

        Timetable timetable4 = new Timetable();
        timetable4.addSlot(1, "Thursday", "13:00", "17:00");
        timetable4.addSlot(2, "Monday", "08:00", "11:00");
        timetable4.addSlot(3, "Wednesday", "14:00", "17:00");
        timetable4.addSlot(4, "Friday", "09:00", "12:00");

// Now assign each timetable to the corresponding therapist
        List<Therapist> therapists = Arrays.asList(
                new Therapist(1, "Sarah Hussain", "41 Bridle Cl, EN3 6EA", "07905625362",
                        Arrays.asList("Neural mobilisation", "Massage", "Pool rehabilitation"), timetable1),
                new Therapist(2, "James Bennet", "45 Lynton Garden, EN1 2NF", "0987654321",
                        Arrays.asList("Acupuncture", "Mobilisation of the spine and joints"), timetable2),
                new Therapist(3, "Zunaed Ahmed", "78 Forest Road, EN3 3ED", "0172398456",
                        Arrays.asList("Massage", "Pool rehabilitation"), timetable3),
                new Therapist(4, "Daniel Steven", "321 High Road, EN2 5AL", "0198765432",
                        Arrays.asList("Neural mobilisation", "Acupuncture", "Mobilisation of the spine and joints"), timetable4)
        );




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



        while (true) {
            System.out.println("\n--- Therapist Management System ---");
            System.out.println("1. Therapist");
            System.out.println("2. Patient");
            System.out.println("3. Appointments");
            System.out.println("4. View Full Calendar Appointments");
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
                        scanner.nextLine();
                        switch (choice2) {
                            case 1://view all therapist
                                for (Therapist therapist : therapists) {
                                    therapist.displayInfo();
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
                        System.out.println("3. Go Back");
                        System.out.print("Enter your choice: ");

                        int choice2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice2) {
                            case 1://Add Patient

                                System.out.println("\nEnter Patient Details:");

                                System.out.print("Name: ");
                                String patieName = scanner.nextLine();

                                System.out.print("Address: ");
                                String patientAddress = scanner.nextLine();

                                System.out.print("Number: ");
                                String patientNumber = scanner.nextLine();

                                patients.add(new Patient(patieName, patientAddress, patientNumber));// Create a Patient object and add it to the list
                                System.out.println("Patient Added successfully, Patient ID is " + patients.getLast().getID());

                                break;


                            case 2:// View All Patient
                                System.out.println("\n=== Patient List ===");
                                for (Patient p : patients) {
                                    System.out.println(p);
                                }
                                break;

                            case 3:
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
                        scanner.nextLine();

                        switch (choice3) {
                            case 1:
                                System.out.println("\n=== Make a Booking ===");
                                System.out.println("Enter your Patient ID:");
                                int patientId = scanner.nextInt();
                                scanner.nextLine();

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

                                Set<String> allTreatments = new HashSet<>();
                                for (Therapist t : therapists) {
                                    allTreatments.addAll(t.getTreatments());
                                }
                                List<String> treatmentList = new ArrayList<>(allTreatments);
                                Collections.sort(treatmentList); // Optional, for nice display

                                System.out.println("Available Treatments:");
                                for (int i = 0; i < treatmentList.size(); i++) {
                                    System.out.println((i + 1) + ". " + treatmentList.get(i));
                                }
                                System.out.println("0. Cancel and return");

                                System.out.print("Select a treatment (0-" + treatmentList.size() + "): ");
                                int treatmentChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (treatmentChoice == 0) {
                                    System.out.println("Cancelled. Returning to main menu...");
                                    break;
                                }

                                if (treatmentChoice < 1 || treatmentChoice > treatmentList.size()) {
                                    System.out.println("Invalid selection.");
                                    break;
                                }

                                String selectedTreatment = treatmentList.get(treatmentChoice - 1);
                                System.out.println("You selected: " + selectedTreatment);


                                List<Therapist> filteredTherapists = new ArrayList<>();
                                for (Therapist t : therapists) {
                                    if (t.treatments.contains(selectedTreatment)) {
                                        filteredTherapists.add(t);
                                    }
                                }

                                System.out.println("Available Therapists for " + selectedTreatment + ":");
                                for (Therapist t : filteredTherapists) {
                                    System.out.println("  " + t.getName() + " (ID: " + t.getID() + ")");
                                }

                                System.out.println("  0. Cancel and return");

                                System.out.print("Enter Therapist ID to book: ");
                                int therapistId = scanner.nextInt();
                                scanner.nextLine();

                                if (therapistId == 0) {
                                    System.out.println("Cancelled!!");
                                    break;
                                }

                                Therapist selected = null;
                                for (Therapist t : filteredTherapists) {
                                    if (t.getID() == therapistId) {
                                        selected = t;
                                        break;
                                    }
                                }

                                if (selected == null) {
                                    System.out.println("Invalid Therapist ID! Returning to main menu...");
                                    break;
                                }

                                Map<Integer, Map<String, List<String>>> availableSlots = selected.getAvailableSlots();// Get the available slots from the therapist

                                System.out.println("\nAvailable Appointment Slots:");
                                int count = 1;
                                Map<Integer, String[]> optionMap = new HashMap<>();

                                // Loops over each week and available slots for the therapist
                                for (Integer week : availableSlots.keySet()) {
                                    for (String day : availableSlots.get(week).keySet()) {
                                        for (String time : availableSlots.get(week).get(day)) {

                                            System.out.println(count + ". Week " + week + " - " + day + " at " + time);
                                            optionMap.put(count, new String[]{String.valueOf(week), day, time});
                                            count++;
                                        }
                                    }
                                }

                                System.out.println("0. Cancel and return");
                                System.out.print("Select a slot (0-" + (count - 1) + "): ");
                                int slotChoice = scanner.nextInt();
                                scanner.nextLine();


                                if (slotChoice == 0) {
                                    System.out.println("Cancelled!!");
                                    break;
                                }


                                if (!optionMap.containsKey(slotChoice)) {
                                    System.out.println("Invalid slot selected.");
                                    break;
                                }

                                // Retrieve the selected week, day, and time
                                String[] chosenSlot = optionMap.get(slotChoice);
                                int selectedWeek = Integer.parseInt(chosenSlot[0]);
                                String day = chosenSlot[1];
                                String time = chosenSlot[2];

                                // Retrieve patient details
                                String patientName = selectedPatient.getName();
                                Integer patientID = selectedPatient.getID();
                                String status = "booked";

                                // Check if already booked in same week, day, time
                                if (bookingManager.isAlreadyBooked(patientID, selectedWeek, day, time)) {
                                    System.out.println("You already have an appointment on Week " + selectedWeek + ", " + day + " at " + time);
                                    break;
                                }

                                // Attempt to book the slot
                                if (selected.book(selectedWeek, day, time)) {
                                    // Create a booking object with the selected week number
                                    Booking booking = new Booking(selected, patientName, patientID, selectedWeek, day, time, selectedTreatment, status);
                                    bookingManager.makeBooking(booking);  // Store the booking with week number

                                } else {
                                    System.out.println("Slot already booked. Try another.");
                                }

                                break;

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
                                    selectedBooking.setBookingStatus(newStatus);
                                    System.out.println("Booking status updated successfully.");
                                } else {
                                    System.out.println("Invalid status input.");
                                }
                                break;
                            case 4:

                                break;
                        }break;

                    }break;

                case 4:
                    bookingManager.displayCalendar();
                    break;
                case 5:

                    System.out.println("Exiting the program. Thank You!");
                    scanner.close();
                    System.exit(0);



                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Map<Integer, Map<String, List<String>>> createSingleDayWeeklySchedule(
            String[] days, String[] startTimes, String[] endTimes) {

        Map<Integer, Map<String, List<String>>> schedule = new HashMap<>();

        for (int week = 0; week < 4; week++) {
            Map<String, List<String>> weekSchedule = new HashMap<>();
            weekSchedule.put(days[week], generateTimeSlots(startTimes[week], endTimes[week]));
            schedule.put(week + 1, weekSchedule);
        }

        return schedule;
    }

    private static List<String> generateTimeSlots(String start, String end) {
        List<String> slots = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date startTime = sdf.parse(start);
            Date endTime = sdf.parse(end);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startTime);

            while (calendar.getTime().before(endTime)) {
                slots.add(sdf.format(calendar.getTime()));
                calendar.add(Calendar.MINUTE, 60);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return slots;
    }

}