package org.bpcms;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void makeBooking(Booking booking) {
        int selectedWeek = booking.getWeekNumber();
        String day = booking.getDay();
        String time = booking.getTime();
       bookings.add(booking);
        System.out.println("Booking successful for Week " + selectedWeek + " - " + day + " at " + time + ", and your booking ID is " + bookings.getLast().getBookingID());

    }

    public void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("--------------------------------");
            System.out.println("No bookings made yet.");
            return;
        }

        System.out.println("All Bookings:");
        System.out.println("------------------------------");
        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }
    public List<Booking> getBookingsByPatient(String patientName) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getPatientName().equalsIgnoreCase(patientName)) {
                result.add(b);
            }
        }
        return result;
    }

    public BookingManager() {
        bookings = new ArrayList<>();
    }

    // This is the new method to display the 4-week calendar
    public void displayCalendar() {
        Map<Integer, List<Booking>> bookingsByWeek = new TreeMap<>();

        for (Booking b : bookings) {
            bookingsByWeek.computeIfAbsent(b.getWeekNumber(), k -> new ArrayList<>()).add(b);
        }

        for (int week = 1; week <= 4; week++) {
            System.out.println("\nWEEK " + week + " APPOINTMENTS:");
            System.out.println("------------------------------------------------------------");

            if (!bookingsByWeek.containsKey(week)) {
                System.out.println("No appointments this week.");
                continue;
            }

            List<Booking> weekBookings = bookingsByWeek.get(week);
            // Sort by therapist then by day/time
            weekBookings.sort(Comparator.comparing((Booking b) -> b.getTherapist().getName())
                    .thenComparing(Booking::getDay)
                    .thenComparing(Booking::getTime));

            for (Booking b : weekBookings) {
                System.out.printf("Therapist: %-20s | Treatment: %-30s\n",
                        b.getTherapist().getName(),  b.getTreatment());
                System.out.printf("  Patient: %-20s | Day: %-10s Time: %-5s | Status: %-10s\n",
                        b.getPatientName(), b.getDay(), b.getTime(), b.getStatus());
                System.out.println("------------------------------------------------------------");
            }
        }
    }

    public boolean isAlreadyBooked(int patientID, int week, String day, String time) {
        for (Booking booking : bookings) {
            if (
                    booking.getPatientID() == patientID &&
                            booking.getWeekNumber() == week &&
                            booking.getDay().equals(day) &&
                            booking.getTime().equals(time) &&
                            booking.getStatus().equalsIgnoreCase("booked")
            ) {
                return true;
            }
        }
        return false;
    }



}
