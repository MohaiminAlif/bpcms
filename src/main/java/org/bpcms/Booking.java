package org.bpcms;

public class Booking {
    private static int initialId = 2500001;
    private int id;
    Therapist therapist;
    private String patientName;
    int patientID;
    String day;
    String time;
    String status;

    public Booking(Therapist therapist, String patientName, int patientID, String day, String time, String status) {
        this.id = generateID();
        this.therapist = therapist;
        this.patientName = patientName;
        this.patientID = patientID;
        this.day = day;
        this.time = time;
        this.status = status;
    }
    private int generateID() {
        return initialId++;

    }

    public int getBookingID() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getSummary() {
        return String.format("Appoint ID: %s | Therapist: %s | Patient: %s | Date: %s | Time: %s | Status: %s",
                getBookingID(), therapist.getName(), patientName, day, time, status);
    }



    public void displayBooking() {
        System.out.println("Appointment ID: " + this.id);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient: " + patientName);
        System.out.println("Therapist: " + therapist.getName());
        System.out.println("Day: " + day);
        System.out.println("Time: " + time);
        System.out.println("Appointment Status: " + status);
        System.out.println("------------------------------");
    }

    public String getPatientName() {
        return patientName;
    }


}

