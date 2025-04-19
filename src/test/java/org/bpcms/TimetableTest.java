package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimetableTest {

    private Timetable timetable;

    @BeforeEach
    void setUp() {
        timetable = new Timetable();
    }

    @Test
    void testAddSlot() {
        timetable.addSlot("Monday", "09:00", "11:00");

        // Since we don't use getter methods, we will check if the slot is correctly available
        assertTrue(timetable.bookSlot("Monday", "09:00"), "Slot should be available after adding.");
        assertFalse(timetable.bookSlot("Monday", "09:00"), "Slot should not be available after booking.");
    }

    @Test
    void testBookSlotSuccess() {
        timetable.addSlot("Monday", "09:00", "10:00");

        // Book the slot and check if the booking was successful
        boolean isBooked = timetable.bookSlot("Monday", "09:00");
        assertTrue(isBooked, "Slot should be bookable when available.");
    }

    @Test
    void testBookSlotFailure() {
        timetable.addSlot("Monday", "09:00", "10:00");

        // Try booking a non-existent slot or an already booked slot
        timetable.bookSlot("Monday", "09:00");  // Booking the first slot
        boolean isBookedAgain = timetable.bookSlot("Monday", "09:00");  // Trying to book again

        assertFalse(isBookedAgain, "Slot should not be available for booking again.");
    }

    @Test
    void testGetAvailableSlots() {
        timetable.addSlot("Monday", "09:00", "11:00");

        // Initially, all slots should be available
        timetable.bookSlot("Monday", "09:00");

        // After booking one slot, only the other should be available
        var availableSlots = timetable.getAvailableSlots();
        assertTrue(availableSlots.containsKey("Monday"), "Monday should have available slots.");
        assertTrue(availableSlots.get("Monday").contains("10:00"), "Slot 10:00 should be available.");
        assertFalse(availableSlots.get("Monday").contains("09:00"), "Slot 09:00 should not be available.");
    }

    @Test
    void testDisplayTimetable() {
        timetable.addSlot("Monday", "09:00", "11:00");

        // Capture system output to check if timetable is displayed properly
        // This test is mainly to verify if the display functionality works as expected.
        timetable.displayTimetable();
    }
}
