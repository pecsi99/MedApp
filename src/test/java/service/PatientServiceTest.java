package service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Patient;
import org.example.repository.PatientRepository;
import org.example.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PatientServiceTest {
    @Mock
    private PatientRepository patientRepositoryMock;
    @InjectMocks
    private PatientService underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllReturnsPatientList() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Teszt Elek");

        List<Patient> expectedPatients = List.of(patient);

        when(patientRepositoryMock.findAll()).thenReturn(expectedPatients);

        List<Patient> result = underTest.findAll();

        assertIterableEquals(expectedPatients, result);
    }

    @Test
    void deletePatientById() {
        int id = 1;
        underTest.deleteById(id);
        verify(patientRepositoryMock).deleteById(id);
    }

    @Test
    void addPatient() {
        Patient expectedPatient = new Patient();
        expectedPatient.setId(1);
        expectedPatient.setName("Teszt Elek");

        when(patientRepositoryMock.save(expectedPatient)).
                thenReturn(expectedPatient);
        Patient result = underTest.addPatient(expectedPatient);

        assertEquals(expectedPatient, result);

    }

    @Test
    void findPatientWhenMissing() {
        int id = 1;
        Patient expectedPatient = new Patient();
        expectedPatient.setId(id);
        expectedPatient.setName("Teszt Elek");
        String exceptionMessage = "Nincs ilyen orvos";

        Optional<Patient> expectedPatintOptional = Optional.empty();

        when(patientRepositoryMock.findById(id)).thenReturn(expectedPatintOptional);

        Exception exception =
                assertThrows(EntityNotFoundException.class,
                        () -> underTest.findByid(id));

        assertEquals(exception.getMessage(), exceptionMessage);

    }

    @Test
    void findPatientWhenPresent() {
        int id = 1;
        Patient expectedPatient = new Patient();
        expectedPatient.setId(id);
        expectedPatient.setName("Teszt Elek");
        Optional<Patient> expectedPatientOptional = Optional.of(expectedPatient);

        when(patientRepositoryMock.findById(id)).thenReturn(expectedPatientOptional);

        Patient result = underTest.findByid(id);

        assertEquals(expectedPatient, result);
    }

}


