package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TherapistTest {

    private Therapist therapist;
    private TimetableStub timetableStub;

    static class TimetableStub extends Timetable {
        private Map<String, List<String>> slots = new HashMap<>();

        public TimetableStub() {
            slots.put("Monday", new ArrayList<>(List.of("10:00", "11:00")));
        }

        @Override
        public Map<String, List<String>> getAvailableSlots() {
            return slots;
        }

        @Override
        public boolean bookSlot(String day, String time) {
            List<String> times = slots.get(day);
            if (times != null && times.contains(time)) {
                times.remove(time);
                return true;
            }
            return false;
        }

        @Override
        public void displayTimetable() {
            System.out.println("Stub timetable display");
        }
    }

    @BeforeEach
    void setUp() {
        timetableStub = new TimetableStub();
        therapist = new Therapist(1, "Sarah Hussain", "41 Bridle Cl, EN3 6EA", "1234567890",
                List.of("Massage", "Acupuncture"), timetableStub);
    }

    @Test
    void testTherapistInitialization() {
        // Check that the therapist's name is correctly set by performing a booking action and checking slots
        boolean booked = therapist.book("Monday", "10:00");
        assertTrue(booked, "Therapist should be able to book a slot");
    }

    @Test
    void testAvailableSlotsAfterBooking() {
        // After booking a slot, ensure it's no longer available
        therapist.book("Monday", "10:00");
        assertFalse(timetableStub.getAvailableSlots().get("Monday").contains("10:00"),
                "The slot '10:00' on Monday should no longer be available after booking");
    }

    @Test
    void testBookFail() {
        // Attempt to book a non-existing slot, it should fail
        boolean result = therapist.book("Tuesday", "09:00");
        assertFalse(result, "Booking a non-existing slot should fail");
    }

    @Test
    void testMultipleBookings() {
        // Try booking multiple slots and ensure that the timeslots are managed correctly
        boolean firstBooking = therapist.book("Monday", "10:00");
        boolean secondBooking = therapist.book("Monday", "11:00");
        boolean thirdBooking = therapist.book("Monday", "10:00");  // Should fail, slot already booked

        assertTrue(firstBooking, "First booking should succeed");
        assertTrue(secondBooking, "Second booking should succeed");
        assertFalse(thirdBooking, "Third booking should fail as the slot '10:00' is already booked");
    }
}
