package org.bpcms;
import java.util.List;
import java.util.Map;

public class Therapist {
    private int id;
    private String name;
    private String address;
    private String telephone;
    public List<String> treatments;
    private Timetable timetable;

    public Therapist(int id, String name, String address, String telephone,
                     List<String> treatments, Timetable timetable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.treatments = treatments;
        this.timetable = timetable;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Telephone: " + telephone);
        System.out.println("Treatments Offered: " + String.join(", ", treatments));
        System.out.println("Timetable:");
        timetable.displayTimetable();
        System.out.println("-------------------------------------");
    }

    public Therapist(int id, String name, List<String> treatments) {
        this.id = id;
        this.name = name;
        this.treatments = treatments;
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Map<String, List<String>>> getAvailableSlots() {
        return timetable.getAvailableSlots();
    }

    public boolean book(int week, String day, String time) {
        return timetable.bookSlot(week, day, time);
    }

}
