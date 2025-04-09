package org.bpcms;

import java.util.ArrayList;
import java.util.List;

public class TherapistManager {
    // ArrayList to store Therapist objects
    private List<Therapist> therapists;

    // Constructor
    public TherapistManager() {
        therapists = new ArrayList<>();
    }

    // Add a therapist
    public void addTherapist(Therapist therapist) {
        for (Therapist t : therapists) {
            if (t.getUniqueId() == therapist.getUniqueId()) {
                System.out.println("Therapist with this ID already exists!");
                return;
            }
        }
        therapists.add(therapist);
    }

    // Retrieve all therapists
    public List<Therapist> getAllTherapists() {
        return therapists;
    }

    // Retrieve a therapist by ID
    public Therapist getTherapistById(int uniqueId) {
        for (Therapist therapist : therapists) {
            if (therapist.getUniqueId() == uniqueId) {
                return therapist;
            }
        }
        return null; // Therapist not found
    }

    // Update a therapist
    public boolean updateTherapist(int uniqueId, String name, String address, String number, String email) {
        Therapist therapist = getTherapistById(uniqueId);
        if (therapist != null) {
            therapist = new Therapist(uniqueId, name, address, number, email);
            return true;
        }
        return false; // Therapist not found
    }

    // Delete a therapist
    public boolean deleteTherapist(int uniqueId) {
        Therapist therapist = getTherapistById(uniqueId);
        if (therapist != null) {
            therapists.remove(therapist);
            return true;
        }
        return false; // Therapist not found
    }
}