package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TherapistManagerTest {

    private TherapistManager therapistManager;

    @BeforeEach
    void setUp() {
        therapistManager = new TherapistManager();
    }

    @Test
    void testAddTherapist() {
        Therapist therapist = new Therapist(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
        therapistManager.addTherapist(therapist);

        List<Therapist> therapists = therapistManager.getAllTherapists();
        assertEquals(1, therapists.size());
        assertEquals(therapist, therapists.get(0));
    }

    @Test
    void testGetAllTherapists() {
        Therapist therapist1 = new Therapist(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
        Therapist therapist2 = new Therapist(2, "Jane Smith", "456 Elm St", "555-5678", "jane@example.com");

        therapistManager.addTherapist(therapist1);
        therapistManager.addTherapist(therapist2);

        List<Therapist> therapists = therapistManager.getAllTherapists();
        assertEquals(2, therapists.size());
        assertTrue(therapists.contains(therapist1));
        assertTrue(therapists.contains(therapist2));
    }

    @Test
    void testGetTherapistById() {
        Therapist therapist = new Therapist(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
        therapistManager.addTherapist(therapist);

        Therapist foundTherapist = therapistManager.getTherapistById(1);
        assertNotNull(foundTherapist);
        assertEquals(therapist, foundTherapist);

        Therapist notFoundTherapist = therapistManager.getTherapistById(999);
        assertNull(notFoundTherapist);
    }

//    @Test
//    void testUpdateTherapist() {
//        Therapist therapist = new Therapist(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
//        therapistManager.addTherapist(therapist);
//
//        boolean isUpdated = therapistManager.updateTherapist(1, "John Doe Updated", "456 New St", "555-9876", "john.updated@example.com");
//        assertTrue(isUpdated);
//
//        Therapist updatedTherapist = therapistManager.getTherapistById(1);
//        assertEquals("John Doe Updated", updatedTherapist.getName());
//        assertEquals("456 New St", updatedTherapist.getAddress());
//        assertEquals("555-9876", updatedTherapist.getNumber());
//        assertEquals("john.updated@example.com", updatedTherapist.getEmail());
//
//        boolean notUpdated = therapistManager.updateTherapist(999, "Non Existent", "No Address", "000-0000", "none@example.com");
//        assertFalse(notUpdated);
//    }

    @Test
    void testDeleteTherapist() {
        Therapist therapist = new Therapist(1, "John Doe", "123 Main St", "555-1234", "john@example.com");
        therapistManager.addTherapist(therapist);

        boolean isDeleted = therapistManager.deleteTherapist(1);
        assertTrue(isDeleted);
        assertEquals(0, therapistManager.getAllTherapists().size());

        boolean notDeleted = therapistManager.deleteTherapist(999);
        assertFalse(notDeleted);
    }
}