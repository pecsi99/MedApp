package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Appointment;
import org.example.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    //    public AppointmentService(
    //    AppointmentRepository appointmentRepository) {
//
//        this.appointmentRepository = appointmentRepository;
//    }
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findByid(int id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {

            return appointment.get();

        } else {
            throw new EntityNotFoundException("No appointment");
        }
    }

    public void deleteByid(int id) {
        appointmentRepository.deleteById(id);
    }

    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
