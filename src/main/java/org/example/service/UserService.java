package org.example.service;


import org.example.modell.Doctor;
import org.example.modell.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private final List<User> users = new ArrayList<>();
    private final DoctorService doctorService;

    public UserService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public boolean requestAppointment(int userId, int doctorId, LocalDate date) {
        User user = getUserById(userId);
        Doctor doctor = doctorService.findById(doctorId);

        if (user != null && doctor != null) {
            boolean success = doctorService.addPatientToDoctor(doctorId, user);

            if (success) {
                user.getAppointments().put(doctor.getName(), date);
                return true;
            }
        }
        return false;
    }

    public Map<String, LocalDate> getAppointments(int userId) {
        User user = getUserById(userId);
        return user != null ? user.getAppointments() : null;
    }

}

