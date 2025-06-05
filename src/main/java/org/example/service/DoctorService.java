package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Doctor;
import org.example.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

//    public DoctorService(DoctorRepository doctorRepository) {
//        this.doctorRepository = doctorRepository;
//    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
    //void
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor findByid(int id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        } else {
            throw new EntityNotFoundException("Nincs ilyen orvos");
        }
    }
}
