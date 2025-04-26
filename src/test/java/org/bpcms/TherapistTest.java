package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TherapistTest {

    private Therapist therapist;
    private Timetable timetable;

    @BeforeEach
    void setUp() {
        // Set up a simple timetable
        timetable = new Timetable();
        timetable.addSlot(1, "Monday", "09:00", "10:00"); // Adds 09:00, 09:30
        timetable.addSlot(1, "Tuesday", "10:00", "11:00"); // Adds 10:00, 10:30

        // Create therapist
        therapist = new Therapist(
                1,
                "Sarah Hussain",
                "41 Bridle Cl, EN3 6EA",
                "07905625362",
                Arrays.asList("Massage", "Acupuncture"),
                timetable
        );
    }


    @Test
    void testBookSlotSuccessfully() {
        boolean booked = therapist.book(1, "Monday", "09:00");
        assertTrue(booked, "Booking should succeed for available slot");

        // After booking, the slot should no longer be available
        Map<Integer, Map<String, List<String>>> availableSlots = therapist.getAvailableSlots();
        List<String> mondaySlots = availableSlots.get(1).get("Monday");
        assertFalse(mondaySlots.contains("09:00"), "09:00 should no longer be available after booking");
    }
    @Test
    void testBookSlotAlreadyBooked() {
        // Book once
        assertTrue(timetable.bookSlot(1, "Monday", "09:00"), "First booking should succeed");

        // Try booking again
        assertFalse(timetable.bookSlot(1, "Monday", "09:00"), "Second booking for same slot should fail");
    }


}
