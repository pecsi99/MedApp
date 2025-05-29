package org.example;

import org.example.modell.User;
import org.example.service.DoctorService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoctorService doctorService=new DoctorService();
        System.out.println(doctorService.findById(1));
        doctorService.addPatientToDoctor(1,)

    }
}