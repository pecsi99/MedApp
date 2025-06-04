package org.example.service;

import org.example.model.Doctor;
import org.example.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServive {
    private DoctorRepository doctorRepository;

    public DoctorServive(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }
    public void delete(int id){
        doctorRepository.deleteById(id);
    }
    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
}
