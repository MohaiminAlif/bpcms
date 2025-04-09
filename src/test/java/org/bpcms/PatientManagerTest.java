package org.bpcms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PatientManagerTest {

    private PatientManager patientManager;

    @BeforeEach
    void setUp() {
        patientManager = new PatientManager();
    }

    @Test
    void testAddPatient() {
        Patient patient = new Patient(1, "Alice Smith", "123 Main St", "555-1234", "alice@example.com");
        patientManager.addPatient(patient);

        List<Patient> patients = patientManager.getAllPatients();
        assertEquals(1, patients.size());
        assertEquals(patient, patients.get(0));
    }

    @Test
    void testGetAllPatients() {
        Patient patient1 = new Patient(1, "Alice Smith", "123 Main St", "555-1234", "alice@example.com");
        Patient patient2 = new Patient(2, "Bob Johnson", "456 Elm St", "555-5678", "bob@example.com");

        patientManager.addPatient(patient1);
        patientManager.addPatient(patient2);

        List<Patient> patients = patientManager.getAllPatients();
        assertEquals(2, patients.size());
        assertTrue(patients.contains(patient1));
        assertTrue(patients.contains(patient2));
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient(1, "Alice Smith", "123 Main St", "555-1234", "alice@example.com");
        patientManager.addPatient(patient);

        Patient foundPatient = patientManager.getPatientById(1);
        assertNotNull(foundPatient);
        assertEquals(patient, foundPatient);

        Patient notFoundPatient = patientManager.getPatientById(999);
        assertNull(notFoundPatient);
    }

//    @Test
//    void testUpdatePatient() {
//        Patient patient = new Patient(1, "Alice Smith", "123 Main St", "555-1234", "alice@example.com");
//        patientManager.addPatient(patient);
//
//        boolean isUpdated = patientManager.updatePatient(1, "Alice Smith Updated", "456 New St", "555-9876", "alice.updated@example.com");
//        assertTrue(isUpdated);
//
//        Patient updatedPatient = patientManager.getPatientById(1);
//        assertEquals("Alice Smith Updated", updatedPatient.getName());
//        assertEquals("456 New St", updatedPatient.getAddress());
//        assertEquals("555-9876", updatedPatient.getNumber());
//        assertEquals("alice.updated@example.com", updatedPatient.getEmail());
//
//        boolean notUpdated = patientManager.updatePatient(999, "Non Existent", "No Address", "000-0000", "none@example.com");
//        assertFalse(notUpdated);
//    }

    @Test
    void testDeletePatient() {
        Patient patient = new Patient(1, "Alice Smith", "123 Main St", "555-1234", "alice@example.com");
        patientManager.addPatient(patient);

        boolean isDeleted = patientManager.deletePatient(1);
        assertTrue(isDeleted);
        assertEquals(0, patientManager.getAllPatients().size());

        boolean notDeleted = patientManager.deletePatient(999);
        assertFalse(notDeleted);
    }
}