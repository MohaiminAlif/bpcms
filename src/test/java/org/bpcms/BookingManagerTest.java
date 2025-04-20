package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingManagerTest {

    private BookingManager bookingManager;
    private Therapist therapist;

    @BeforeEach
    void setUp() {
        bookingManager = new BookingManager();
        therapist = new Therapist(1, "Sarah Hussain", "12 Main St", "1234567890",
                List.of("Massage", "Acupuncture"), new TherapistTest.TimetableStub());
    }

    @Test
    void testShowAllBookingsDisplaysAtLeastOne() {
        bookingManager.makeBooking(therapist, "Abid Hussain", 250420001, "Monday", "11:00", "Pending");

        // Again, this would normally check printed output.
        // We just ensure it runs without errors.
        assertDoesNotThrow(() -> bookingManager.showAllBookings());
    }

    @Test
    void testGetBookingsByPatientReturnsCorrectBooking() {
        bookingManager.makeBooking(therapist, "Yasin", 250420003, "Monday", "10:00", "Pending");
        bookingManager.makeBooking(therapist, "Mohsin", 250420002, "Monday", "11:00", "Pending");

        List<Booking> results = bookingManager.getBookingsByPatient("Yasin");

        assertEquals(1, results.size(), "Should return one booking for Yasin.");
        assertTrue(results.getFirst().getSummary().contains("Patient: Yasin"));
    }

    @Test
    void testMultipleBookingsSamePatient() {
        bookingManager.makeBooking(therapist, "Kalam", 105, "Tuesday", "10:00", "Pending");
        bookingManager.makeBooking(therapist, "Kalam", 105, "Wednesday", "10:30", "Pending");

        List<Booking> bookings = bookingManager.getBookingsByPatient("Kalam");

        assertEquals(2, bookings.size(), "Should return two bookings for Kalam.");
        assertTrue(bookings.get(0).getSummary().contains("Kalam"));
        assertTrue(bookings.get(1).getSummary().contains("Kalam"));
    }
}
