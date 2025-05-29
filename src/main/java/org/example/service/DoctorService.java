package org.example.service;

import org.example.modell.Doctor;
import org.example.modell.User;

import java.util.ArrayList;
import java.util.List;


public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>(List.of(
            new Doctor(1, "Dr. Kovács", "Kardiológia", new ArrayList<>()),
            new Doctor(2, "Dr. Szabó", "Neurológia", new ArrayList<>()),
            new Doctor(3, "Dr. Nagy", "Sebészet", new ArrayList<>()),
            new Doctor(4, "Dr. Tóth", "Urológia", new ArrayList<>()),
            new Doctor(5, "Dr. Farkas", "Onkológia", new ArrayList<>()),
            new Doctor(6, "Dr. Kiss", "Dermatológia", new ArrayList<>()),
            new Doctor(7, "Dr. Horváth", "Endokrinológia", new ArrayList<>()),
            new Doctor(8, "Dr. Molnár", "Gyermekgyógyászat", new ArrayList<>()),
            new Doctor(9, "Dr. Balogh", "Reumatológia", new ArrayList<>()),
            new Doctor(10, "Dr. Varga", "Gasztroenterológia", new ArrayList<>())
    ));



    public void registerDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

//    public Doctor getDoctorById(int id) {
//        return doctors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
//    }
public Doctor findById(int id) {
    for (Doctor doctor : doctors) {
        if (doctor.getId() == id) {
            return doctor;
        }
    }
    return null;
}

    public boolean addPatientToDoctor(int doctorId, User user) {
        Doctor doctor = findById(doctorId);
        if (doctor != null && !doctor.getPatients().contains(user)) {
            doctor.getPatients().add(user);
            return true;
        }
        return false;
    }


    public List<User> getPatients(int doctorId) {
        Doctor doctor = findById(doctorId);
        return doctor != null ? doctor.getPatients() : null;
    }
    }


