package org.example;

public class Patient {
    private int patient_id;
    private String patient_name;
    private String patient_address;
    private String patient_number;
    private String patient_email;

    public Patient(int patient_id, String patient_name, String patient_address, String patient_number, String patient_email) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_address = patient_address;
        this.patient_number = patient_number;
        this.patient_email = patient_email;
    }

    // Getters
    public int getUniqueId() {
        return patient_id;
    }

    public String getName() {
        return patient_name;
    }

    public String getAddress() {
        return patient_address;
    }

    public String getNumber() {
        return patient_number;
    }

    public String getEmail() {
        return patient_email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", address='" + patient_address + '\'' +
                ", number='" + patient_number + '\'' +
                ", email='" + patient_email + '\'' +
                '}';
    }
}