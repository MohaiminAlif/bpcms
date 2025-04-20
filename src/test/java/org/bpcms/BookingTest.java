package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Therapist therapist;
    private Booking booking;

    @BeforeEach
    void setUp() {
        // Set up a mock therapist and booking
        therapist = new Therapist(1, "Sarah Hussain", "12 Main St", "1234567890", List.of("Massage", "Acupuncture"), new Timetable());
        booking = new Booking(therapist, "Abid Hussain", 250420001, "Monday", "10:00", "Pending");
    }

    @Test
    void testBookingInitialization() {
        // Test that the booking object is initialized correctly.
        assertNotNull(booking, "Booking object should be created.");
    }


    @Test
    void testBookingStatusChange() {
        // Test changing the booking status
        booking.setBookingStatus("Confirmed");

        // Verify that the status was updated correctly
        assertTrue(booking.getSummary().contains("Confirmed"), "Booking status should be updated.");
    }

}
