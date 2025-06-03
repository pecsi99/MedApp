package org.example.controller;

import org.example.model.Doctor;
import org.example.service.DoctorServive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    public DoctorServive doctorServive;

    public DoctorController(DoctorServive doctorServive) {
        this.doctorServive = doctorServive;
    }

    @GetMapping("/index")
    public String Hello(Model model){
        return "index";

    }
    @GetMapping("/list")
    public String findAll(Model model){
        List<Doctor> doctorList=doctorServive.findAll();
        model.addAttribute("doctors",doctorList);
        return "doctor/listall";

    }
}
