package org.bpcms;


public class Booking {
    private static int initialId = 2500001;
    private int id;
    private Therapist therapist;
    private String patientName;
    private int patientID;
    private int weekNumber;
    private String day;
    private String time;
    private String status;
    private String treatment;


    public Booking(Therapist therapist, String patientName, int patientID, int weekNumber, String day, String time, String treatment, String status) {
        this.id = generateID();
        this.therapist = therapist;
        this.patientName = patientName;
        this.patientID = patientID;
        this.weekNumber = weekNumber;
        this.day = day;
        this.time = time;
        this.status = status;
        this.treatment = treatment;
    }
    private int generateID() {
        return initialId++;

    }

    public int getBookingID() {
        return id;
    }

    public void setBookingStatus(String status) {
        this.status = status;
    }

    // Add getter for weekNumber
    public int getWeekNumber() {
        return weekNumber;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public Therapist getTherapist() { return therapist; }

    public String getTreatment() { return treatment; }


    public String getSummary() {
        return String.format("Appoint ID: %s | Therapist: %s | Patient: %s | Week: %s | Date: %s | Time: %s | Status: %s",
                getBookingID(), therapist.getName(), patientName, weekNumber, day, time, status);
    }

    public int getPatientID() {
        return patientID;
    }

    public int getWeek(){
        return weekNumber;
    }


    public void displayBooking() {
        System.out.println("Appointment ID: " + this.id);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient: " + patientName);
        System.out.println("Therapist: " + therapist.getName());
        System.out.println("Week Number: " + weekNumber);
        System.out.println("Day: " + day);
        System.out.println("Time: " + time);
        System.out.println("Appointment Status: " + status);
        System.out.println("------------------------------");
    }

    public String getPatientName() {
        return patientName;
    }


}

