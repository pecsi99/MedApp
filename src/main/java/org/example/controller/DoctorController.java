package org.example.controller;

import org.example.model.Doctor;
import org.example.service.DoctorServive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id, Model model) {
        doctorServive.delete(id);
        List<Doctor> doctorList = doctorServive.findAll();
        model.addAttribute("doctors", doctorList);
        return "doctor/listall";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/add";
    }
    @PostMapping("/add")
    public String addDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorServive.addDoctor(doctor);
        return "redirect:/doctors/list"; // redirect → újratöltés, nincs duplázás
    }


//    @PostMapping("/add")
//    public String updateDoctor(@ModelAttribute Doctor doctor, Model model){
//        doctorServive.addDoctor(doctor);
//        List<Doctor> doctorList = doctorServive.findAll();
//        model.addAttribute("doctors", doctorList);
//        return "doctor/listall";
//
//    }

}
