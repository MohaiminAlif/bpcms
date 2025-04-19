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
    
}
