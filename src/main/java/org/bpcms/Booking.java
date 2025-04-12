package org.bpcms;

public class Booking {
    Therapist therapist;
    private String patientName;
    String day;
    String time;

    public Booking(Therapist therapist, String patientName, String day, String time) {
        this.therapist = therapist;
        this.patientName = patientName;
        this.day = day;
        this.time = time;
    }

    public void displayBooking() {
        System.out.println("Patient: " + patientName);
        System.out.println("Therapist: " + therapist.getName());
        System.out.println("Day: " + day);
        System.out.println("Time: " + time);
        System.out.println("------------------------------");
    }
}

