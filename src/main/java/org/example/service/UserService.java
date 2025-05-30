package org.example.service;


import org.example.modell.Doctor;
import org.example.modell.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
@Service
public class UserService {
    private List<User> users = new ArrayList<>(List.of(
            new User(1, "Anna", "anna@example.com", new HashMap<>()),
            new User(2, "Béla", "bela@example.com", new HashMap<>()),
            new User(3, "Csaba", "csaba@example.com", new HashMap<>()),
            new User(4, "Dóra", "dora@example.com", new HashMap<>()),
            new User(5, "Eszter", "eszter@example.com", new HashMap<>()),
            new User(6, "Ferenc", "ferenc@example.com", new HashMap<>()),
            new User(7, "Gábor", "gabor@example.com", new HashMap<>()),
            new User(8, "Hanna", "hanna@example.com", new HashMap<>()),
            new User(9, "István", "istvan@example.com", new HashMap<>()),
            new User(10, "Judit", "judit@example.com", new HashMap<>())
    ));

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

    public boolean requestAppointment(int userId, int doctorId) {
        User user = getUserById(userId);
        Doctor doctor = doctorService.findById(doctorId);

        if (user != null && doctor != null) {
            boolean success = doctorService.addPatientToDoctor(doctorId, user);

            if (success) {
                // Random dátum generálása 1 hónapon (30 napon) belül
                int randomDays = new Random().nextInt(30) + 1;
                LocalDate randomDate = LocalDate.now().plusDays(randomDays);

                user.getAppointments().put(doctor.getName(), randomDate);
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

