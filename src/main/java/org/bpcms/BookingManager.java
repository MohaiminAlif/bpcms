package org.bpcms;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void makeBooking(Therapist therapist, String patientName, String day, String time) {
        // Check if time is already booked
        for (Booking booking : bookings) {
            if (booking.therapist == therapist && booking.day.equalsIgnoreCase(day) && booking.time.equals(time)) {
                System.out.println("This slot is already booked.");
                return;
            }
        }

        bookings.add(new Booking(therapist, patientName, day, time));
        System.out.println("Booking successful!");
    }

    public void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings made yet.");
            return;
        }

        System.out.println("All Bookings:");
        System.out.println("------------------------------");
        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }
}
