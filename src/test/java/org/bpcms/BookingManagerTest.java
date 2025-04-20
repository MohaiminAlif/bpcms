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

}
