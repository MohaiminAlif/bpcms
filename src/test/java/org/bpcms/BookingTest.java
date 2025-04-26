package org.bpcms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BookingTest {

    private Booking booking;
    private Therapist therapist;

    @BeforeEach
    void setUp() {
        // Create a sample therapist for testing
        Therapist therapist = new Therapist(
                1,
                "Sarah Hussain",
                "41 Bridle Cl, EN3 6EA",
                "07905625362",
                Arrays.asList("Massage", "Acupuncture"),
                new Timetable()
        );

        // Create a booking object for testing
        booking = new Booking(
                therapist,
                "Ishrat Jahan",
                250426001,
                2,
                "Monday",
                "10:00",
                "Massage",
                "booked"
        );
    }


    @Test
    void testGetSummaryFormat() {
        String summary = booking.getSummary();

        assertNotNull(summary, "Summary should not be null");

        // Check that the expected keywords are in the summary
        assertTrue(summary.contains("Appoint ID:"), "Summary should contain 'Appoint ID:'");
        assertTrue(summary.contains("Therapist:"), "Summary should contain 'Therapist:'");
        assertTrue(summary.contains("Patient:"), "Summary should contain 'Patient:'");
        assertTrue(summary.contains("Week:"), "Summary should contain 'Week:'");
        assertTrue(summary.contains("Date:"), "Summary should contain 'Date:'");
        assertTrue(summary.contains("Time:"), "Summary should contain 'Time:'");
        assertTrue(summary.contains("Status:"), "Summary should contain 'Status:'");


    }
}
