package org.example.controller;

import org.example.modell.Doctor;
import org.example.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/index")
    public String IndexPage(){
        return "index";

    }
    @GetMapping("list")
    public String listDoctors(Model model){
        List<Doctor> doctors=doctorService.findAll();
        model.addAttribute("doctors",doctors);
        return "doctors/listdoctors";

    }




}
