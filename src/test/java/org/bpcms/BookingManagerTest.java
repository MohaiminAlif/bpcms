package org.bpcms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class TimetableTest {

    private Timetable timetable;

    @BeforeEach
    void setUp() {
        timetable = new Timetable();
        timetable.addSlot(1, "Monday", "09:00", "11:00"); // Adds 09:00 and 09:30 and 10:00 and 10:30 slots
    }

    @Test
    void testAddSlotAndGetAvailableSlots() {
        Map<Integer, Map<String, List<String>>> slots = timetable.getAvailableSlots();
        assertTrue(slots.containsKey(1));
        assertTrue(slots.get(1).containsKey("Monday"));
        assertEquals(4, slots.get(1).get("Monday").size()); // 4 slots between 9:00 and 11:00
    }

    @Test
    void testBookSlotSuccess() {
        boolean booked = timetable.bookSlot(1, "Monday", "09:00");
        assertTrue(booked);

        Map<Integer, Map<String, List<String>>> available = timetable.getAvailableSlots();
        assertFalse(available.get(1).get("Monday").contains("09:00")); // After booking, 09:00 should not be available
    }

    @Test
    void testBookSlotFailure() {
        timetable.bookSlot(1, "Monday", "09:00"); // First booking
        boolean bookedAgain = timetable.bookSlot(1, "Monday", "09:00"); // Try booking same again
        assertFalse(bookedAgain);
    }
}
