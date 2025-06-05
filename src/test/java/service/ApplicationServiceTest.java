package service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Appointment;
import org.example.repository.AppointmentRepository;
import org.example.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationServiceTest {
    @Mock
    AppointmentRepository appointmentRepositoryMock;
    @InjectMocks
    AppointmentService underTest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllReturnsAppointmentList() {
        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setDoctor(null);
        appointment.setPatient(null);
        appointment.setDate(LocalDateTime.now());

        List<Appointment> expectedAppointments = List.of(appointment);

        when(appointmentRepositoryMock.findAll()).thenReturn(expectedAppointments);

        List<Appointment> result = underTest.findAll();

        assertIterableEquals(expectedAppointments, result);
    }

    @Test
    void findAppointmentByIdWhenPresent() {
        int id = 1;
        Appointment expectedAppointment = new Appointment();
        expectedAppointment.setId(id);
        expectedAppointment.setDoctor(null);
        expectedAppointment.setPatient(null);
        expectedAppointment.setDate(LocalDateTime.now());
        Optional<Appointment> expectedAppointmentOptional = Optional.of(expectedAppointment);
        when(appointmentRepositoryMock.findById(id)).thenReturn(expectedAppointmentOptional);

        Appointment result = underTest.findByid(id);

        assertEquals(expectedAppointment, result);

    }

    @Test
    void findAppointmentByIdWhenNotPresent() {
        int id = 1;
        Appointment expectedAppointment = new Appointment();
        expectedAppointment.setId(id);
        expectedAppointment.setDoctor(null);
        expectedAppointment.setPatient(null);
        expectedAppointment.setDate(LocalDateTime.now());
        String exceptionMessage = "No appointment";
        Optional<Appointment> expectedAppointmentOptional = Optional.empty();
        when(appointmentRepositoryMock.findById(id)).thenReturn(expectedAppointmentOptional);
        Exception exception =
                assertThrows(EntityNotFoundException.class,
                        () -> underTest.findByid(id));
        assertEquals(exception.getMessage(), exceptionMessage);


    }

    @Test
    void deleteById() {

        int id = 1;
        underTest.deleteByid(id);
        verify(appointmentRepositoryMock).deleteById(id);


    }

    @Test
    void saveAppointment() {
        int id = 1;
        Appointment expectedAppointment = new Appointment();
        expectedAppointment.setId(id);
        expectedAppointment.setDoctor(null);
        expectedAppointment.setPatient(null);
        expectedAppointment.setDate(LocalDateTime.now());

        when(appointmentRepositoryMock.save(expectedAppointment)).thenReturn(expectedAppointment);

        Appointment result = underTest.save(expectedAppointment);

        assertEquals(expectedAppointment, result);

    }
}

