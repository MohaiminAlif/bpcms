package org.bpcms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TimetableTest {

    private Timetable timetable;

    @BeforeEach
    void setUp() {
        timetable = new Timetable();
        timetable.addSlot(1, "Monday", "09:00", "11:00");  // Should generate 09:00, 09:30, 10:00, 10:30
        timetable.addSlot(2, "Tuesday", "10:00", "11:00"); // 10:00, 10:30
    }

    @Test
    void testAddSlotAndAvailableSlots() {
        Map<Integer, Map<String, List<String>>> available = timetable.getAvailableSlots();

        assertNotNull(available, "Available slots map should not be null");
        assertTrue(available.containsKey(1), "Week 1 should be present");
        assertTrue(available.containsKey(2), "Week 2 should be present");

        List<String> mondaySlots = available.get(1).get("Monday");
        assertEquals(4, mondaySlots.size(), "There should be 4 slots on Monday");
        assertTrue(mondaySlots.contains("09:00"), "09:00 should be available");
        assertTrue(mondaySlots.contains("09:30"), "09:30 should be available");
        assertTrue(mondaySlots.contains("10:00"), "10:00 should be available");
        assertTrue(mondaySlots.contains("10:30"), "10:30 should be available");
    }

    @Test
    void testBookSlotSuccessfully() {
        boolean booked = timetable.bookSlot(1, "Monday", "09:00");
        assertTrue(booked, "Booking 09:00 on Monday week 1 should succeed");

        Map<Integer, Map<String, List<String>>> available = timetable.getAvailableSlots();
        List<String> mondaySlots = available.get(1).get("Monday");
        assertFalse(mondaySlots.contains("09:00"), "09:00 should no longer be available after booking");
    }

    @Test
    void testBookSlotAlreadyBooked() {
        // Book once
        assertTrue(timetable.bookSlot(1, "Monday", "09:00"), "First booking should succeed");

        // Try booking again
        assertFalse(timetable.bookSlot(1, "Monday", "09:00"), "Second booking for same slot should fail");
    }

    @Test
    void testBookSlotInvalidDay() {
        boolean booked = timetable.bookSlot(1, "Sunday", "09:00"); // No Sunday slot
        assertFalse(booked, "Booking for non-existent day should fail");
    }

    @Test
    void testBookSlotInvalidTime() {
        boolean booked = timetable.bookSlot(1, "Monday", "12:00"); // Time not added
        assertFalse(booked, "Booking for non-existent time should fail");
    }

    @Test
    void testBookSlotInvalidWeek() {
        boolean booked = timetable.bookSlot(3, "Monday", "09:00"); // Week 3 not added
        assertFalse(booked, "Booking for non-existent week should fail");
    }
}
