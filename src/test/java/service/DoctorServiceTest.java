package service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Doctor;
import org.example.repository.DoctorRepository;
import org.example.service.DoctorService;
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

public class DoctorServiceTest {
    @InjectMocks
    private DoctorService underTest;
    @Mock
    private DoctorRepository doctorRepositoryMock;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Teszt Elek");
        doctor.setDepartment("Kardiológia");

        List<Doctor> expectedDoctors = List.of(doctor);
        when(doctorRepositoryMock.findAll()).thenReturn(expectedDoctors);

        List<Doctor> result = underTest.findAll();

        assertIterableEquals(expectedDoctors, result);

    }

    @Test
    void deleteDoctorById() {
        int id = 1;
        underTest.delete(id);
        verify(doctorRepositoryMock).deleteById(id);
    }

    @Test
    void addDoctor() {
        Doctor expectedDoctor = new Doctor();
        expectedDoctor.setId(1);
        expectedDoctor.setName("Teszt Elek");

        when(doctorRepositoryMock.save(expectedDoctor)).
                thenReturn(expectedDoctor);
        Doctor result = underTest.addDoctor(expectedDoctor);

        assertEquals(expectedDoctor, result);

    }

    @Test
    void findDoctorByIDWhenPresent() {
        int id = 1;
        Doctor expectedDoctor = new Doctor();
        expectedDoctor.setId(id);
        expectedDoctor.setName("Teszt Elek");
        Optional<Doctor> expectedDoctorOptional = Optional.of(expectedDoctor);

        when(doctorRepositoryMock.findById(id)).thenReturn(expectedDoctorOptional);
        Doctor result = underTest.findByid(id);
        assertEquals(result, expectedDoctor);

    }

    @Test
    void findDoctorByIdWhenNotPresent() {
        int id = 1;
        Doctor expectedDoctor = new Doctor();
        expectedDoctor.setId(id);
        expectedDoctor.setName("Teszt Elek");
        String exceptionMessage = "Nincs ilyen orvos";

        Optional<Doctor> expectedDoctorOptional = Optional.empty();
        when(doctorRepositoryMock.findById(id)).thenReturn(expectedDoctorOptional);

        Exception exception =
                assertThrows(EntityNotFoundException.class,
                        () -> underTest.findByid(id));
        assertEquals(exception.getMessage(), exceptionMessage);

    }
}
