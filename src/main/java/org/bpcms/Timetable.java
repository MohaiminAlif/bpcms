package org.bpcms;
import java.util.*;

public class Timetable {

    private Map<Integer, Map<String, List<String>>> schedule;

    private Set<String> bookedSlots;  // Stores booked slots like "Monday_09:00"

    public Timetable() {
        schedule = new HashMap<>();
        bookedSlots = new HashSet<>();
    }


public void addSlot(int week, String day, String startTime, String endTime) {
    List<String> slots = generateTimeSlots(startTime, endTime);

    // If week is not already in the schedule, create a new map for days
    schedule.putIfAbsent(week, new HashMap<>());

    // Add or update the slots for the given day of the week
    schedule.get(week).put(day, slots);
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
        for (int week = 1; week <= 4; week++) {  // Loop through each week
            System.out.println("Week " + week + ":");
            Map<String, List<String>> weekSchedule = schedule.get(week);

            if (weekSchedule == null || weekSchedule.isEmpty()) {
                System.out.println("  No schedule available for this week.");
            } else {
                for (String day : weekSchedule.keySet()) {
                    System.out.println("  " + day + ": " + String.join(", ", weekSchedule.get(day)));
                }
            }
            System.out.println("-------------------------------------");
        }
    }

    public Map<Integer, Map<String, List<String>>> getAvailableSlots() {
        Map<Integer, Map<String, List<String>>> available = new HashMap<>();

        for (int week : schedule.keySet()) {
            Map<String, List<String>> weekSchedule = schedule.get(week);
            Map<String, List<String>> weekAvailable = new HashMap<>();

            for (String day : weekSchedule.keySet()) {
                List<String> free = new ArrayList<>();
                for (String time : weekSchedule.get(day)) {
                    String key = week + "_" + day + "_" + time;
                    if (!bookedSlots.contains(key)) {
                        free.add(time);
                    }
                }
                if (!free.isEmpty()) {
                    weekAvailable.put(day, free);
                }
            }

            if (!weekAvailable.isEmpty()) {
                available.put(week, weekAvailable);
            }
        }

        return available;
    }

    public boolean bookSlot(int week, String day, String time) {
        // Check if the timetable contains the week
        if (schedule.containsKey(week)) {
            Map<String, List<String>> weekSchedule = schedule.get(week);

            // Check if the day is present for the week
            if (weekSchedule.containsKey(day)) {
                List<String> daySlots = weekSchedule.get(day);

                // Check if the time is available for that day
                if (daySlots.contains(time) && !bookedSlots.contains(week + "_" + day + "_" + time)) {
                    bookedSlots.add(week + "_" + day + "_" + time);
                    return true;
                }
            }
        }
        return false;
    }

}
