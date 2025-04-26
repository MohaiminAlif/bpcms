package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // Create a new Patient instance to test the constructor and ID generation
        patient = new Patient("Ishrat Ara", "123 Liverpool St", "07487362772");
    }

    @Test
    void testGenerateIDUniqueness() {
        // To ensure that IDs are unique per day, create two patients and check that their IDs are different.
        Patient patient2 = new Patient("Ishrat Jahan", "456 Davey Cl", "07487362443");

        int id1 = Integer.parseInt(patient.toString().split(",")[0].split(":")[1].trim());
        int id2 = Integer.parseInt(patient2.toString().split(",")[0].split(":")[1].trim());

        // Check that the two patients have different IDs (ensuring uniqueness for the day)
        assertNotEquals(id1, id2, "IDs should be unique per patient on the same day.");
    }

    @Test
    void testToString() {

        String expectedToString = "Patient ID: " + patient.toString().split(",")[0].split(":")[1].trim() +
                ", Name: Ishrat Ara, Address: 123 Liverpool St, Telephone: 07487362772";

        assertEquals(expectedToString, patient.toString(), "toString() should return the correct string representation.");
    }
}
