package org.bpcms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookingManagerTest {

    private BookingManager bookingManager;
    private Therapist therapist;
    private Booking booking;

    @BeforeEach
    void setUp() {
        bookingManager = new BookingManager();
        therapist = new Therapist(1, "Sarah Hussain", Arrays.asList("Massage", "Acupuncture"));

        Timetable timetable = new Timetable();
        timetable.addSlot(1, "Monday", "09:00", "12:00");

        booking = new Booking(therapist, "Ishrat Ara", 250126001, 1, "Monday", "09:00", "Massage", "booked");
    }

    @Test
    void testMakeBookingPrintsSuccess() {
        // Capture console output (optional for printing tests, usually done with system-out capture)
        bookingManager.makeBooking(booking);
        // Test logic: booking made without error
        assertDoesNotThrow(() -> bookingManager.makeBooking(booking));
    }


    @Test
    void testIsAlreadyBookedReturnsTrue() {
        bookingManager.makeBooking(booking);

        boolean alreadyBooked = bookingManager.isAlreadyBooked(250126001, 1, "Monday", "09:00");

        assertTrue(alreadyBooked, "Patient should already be booked for this time");
    }

}
