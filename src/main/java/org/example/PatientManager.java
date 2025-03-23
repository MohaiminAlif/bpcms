package org.example;

import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    // ArrayList to store Patient objects
    private List<Patient> patients;

    // Constructor
    public PatientManager() {

        patients = new ArrayList<>();
    }

    // Add a patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Retrieve all patient
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Retrieve a therapist by ID
    public Patient getPatientById(int patient_id) {
        for (Patient patient : patients) {
            if (patient.getUniqueId() == patient_id) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    // Update a patient
    public boolean updatePatient(int patient_id, String patient_name, String patient_address, String patient_number, String patient_email) {
        Patient patient = getPatientById(patient_id);
        if (patient != null) {
            patient = new Patient(patient_id, patient_name, patient_address, patient_number, patient_email);
            return true;
        }
        return false; // Patient not found
    }

    // Delete a patient
    public boolean deletePatient(int patient_id) {
        Patient patient = getPatientById(patient_id);
        if (patient != null) {
            patients.remove(patient);
            return true;
        }
        return false; // Patient not found
    }
}