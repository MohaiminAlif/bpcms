package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // Create a new Patient instance to test the constructor and ID generation
        patient = new Patient("John Doe", "123 Main St", "555-1234");
    }

    @Test
    void testPatientInitialization() {
        // Check that the patient object is initialized correctly.
        // We cannot directly access the ID or name, but we can check if the object is created successfully.
        assertNotNull(patient, "Patient object should be created.");
    }

    @Test
    void testGenerateIDFormat() {
        // Create a patient and retrieve its ID to verify the format
        int id = patient.toString().contains("Patient ID: ") ? Integer.parseInt(patient.toString().split(",")[0].split(":")[1].trim()) : -1;

        // The ID format should follow the pattern yyMMddxxx where 'xxx' is the daily counter
        String idStr = String.valueOf(id);
        String datePart = idStr.substring(0, 6);  // The first 6 characters represent the date (yyMMdd)
        String counterPart = idStr.substring(6);  // The last 3 characters represent the counter (xxx)

        // Validate the date part and counter part format
        assertTrue(datePart.matches("\\d{6}"), "ID should start with a 6-digit date part (yyMMdd).");
        assertTrue(counterPart.matches("\\d{3}"), "ID should end with a 3-digit counter part.");
    }

    @Test
    void testGenerateIDUniqueness() {
        // To ensure that IDs are unique per day, create two patients and check that their IDs are different.
        Patient patient2 = new Patient("Jane Doe", "456 Another St", "555-5678");

        int id1 = Integer.parseInt(patient.toString().split(",")[0].split(":")[1].trim());
        int id2 = Integer.parseInt(patient2.toString().split(",")[0].split(":")[1].trim());

        // Check that the two patients have different IDs (ensuring uniqueness for the day)
        assertNotEquals(id1, id2, "IDs should be unique per patient on the same day.");
    }

    @Test
    void testToString() {
        // Test the toString method to ensure the correct format is returned.
        String expectedToString = "Patient ID: " + patient.toString().split(",")[0].split(":")[1].trim() +
                ", Name: John Doe, Address: 123 Main St, Telephone: 555-1234";

        assertEquals(expectedToString, patient.toString(), "toString() should return the correct string representation.");
    }
}
