package org.bpcms;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void makeBooking(Therapist therapist, String patientName, Integer patientID, String day, String time, String status) {

        bookings.add(new Booking(therapist, patientName, patientID, day, time, status));
        System.out.println("Booking successful for " + patientName + "!");
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


}
