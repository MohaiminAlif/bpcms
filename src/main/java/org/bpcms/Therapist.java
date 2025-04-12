package org.bpcms;
import java.util.List;

public class Therapist {
    private int id;
    private String name;
    private String address;
    private String telephone;
    public List<String> treatmentsOffered;
    private Timetable timetable;

    public Therapist(int id, String name, String address, String telephone,
                     List<String> treatmentsOffered, Timetable timetable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.treatmentsOffered = treatmentsOffered;
        this.timetable = timetable;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Telephone: " + telephone);
        System.out.println("Treatments Offered: " + String.join(", ", treatmentsOffered));
        System.out.println("Timetable:");
        timetable.displayTimetable();
        System.out.println("-------------------------------------");
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
