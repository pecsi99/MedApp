package org.example;

import org.example.modell.User;
import org.example.service.DoctorService;
import org.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashMap;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);


//        DoctorService doctorService=new DoctorService();
//        UserService userService = new UserService(doctorService);
//        User user=new User(10, "Judit", "judit@example.com", new HashMap<>());
//        System.out.println(doctorService.findById(1));
//        userService.requestAppointment(10,1);
//        System.out.println(doctorService.getPatients(1));
//        System.out.println(doctorService.findAll());
    }
}