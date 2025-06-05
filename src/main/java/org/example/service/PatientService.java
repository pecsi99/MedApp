package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<Patient> findAll(){
        return patientRepository.findAll();
    }
    public void deleteById(int id){
        patientRepository.deleteById(id);
    }
    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }
    public Patient findByid(int id){
        Optional<Patient> patient=patientRepository.findById(id);
        if(patient.isPresent()){
            return patient.get();
        }
        else {
            throw new EntityNotFoundException("Nincs ilyen orvos");
        }
    }
}
