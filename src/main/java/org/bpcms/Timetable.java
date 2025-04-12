package org.bpcms;
import java.util.*;

public class Timetable {
    private Map<String, String> schedule;

    public Timetable() {
        schedule = new HashMap<>();
    }

    public void setDay(String day, String hours) {
        schedule.put(day, hours);
    }

    public void displayTimetable() {
        for (String day : Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")) {
            String time = schedule.getOrDefault(day, "Off");
            System.out.println("  " + day + ": " + time);
        }
    }
}
