package org.bpcms;
import java.util.*;

public class Timetable {
    private Map<String, List<String>> schedule;  // Day → List of 30-min slots
    private Set<String> bookedSlots;  // Stores booked slots like "Monday_09:00"

    public Timetable() {
        schedule = new HashMap<>();
        bookedSlots = new HashSet<>();
    }

    public void addSlot(String day, String startTime, String endTime) {
        List<String> slots = generateTimeSlots(startTime, endTime);
        schedule.put(day, slots);
    }

    private List<String> generateTimeSlots(String start, String end) {
        List<String> slots = new ArrayList<>();
        String[] startParts = start.split(":");
        String[] endParts = end.split(":");

        int startMinutes = Integer.parseInt(startParts[0]) * 60 + Integer.parseInt(startParts[1]);
        int endMinutes = Integer.parseInt(endParts[0]) * 60 + Integer.parseInt(endParts[1]);

        while (startMinutes < endMinutes) {
            int hour = startMinutes / 60;
            int minute = startMinutes % 60;
            String timeStr = String.format("%02d:%02d", hour, minute);
            slots.add(timeStr);
            startMinutes += 30;
        }

        return slots;
    }

    public void displayTimetable() {
        for (String day : schedule.keySet()) {
            System.out.println("  " + day + ": " + String.join(", ", schedule.get(day)));
        }
    }

    public Map<String, List<String>> getAvailableSlots() {
        Map<String, List<String>> available = new HashMap<>();
        for (String day : schedule.keySet()) {
            List<String> free = new ArrayList<>();
            for (String time : schedule.get(day)) {
                if (!bookedSlots.contains(day + "_" + time)) {
                    free.add(time);
                }
            }
            if (!free.isEmpty()) {
                available.put(day, free);
            }
        }
        return available;
    }

    public boolean bookSlot(String day, String time) {
        String key = day + "_" + time;
        if (schedule.containsKey(day) && schedule.get(day).contains(time) && !bookedSlots.contains(key)) {
            bookedSlots.add(key);
            return true;
        }
        return false;
    }
}
