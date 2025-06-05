package org.example.controller;

import org.example.model.Doctor;
import org.example.service.DoctorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    public DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/index")
    public String Hello(Model model){
        return "index";

    }
    @GetMapping("/list")
    public String findAll(Model model){
        List<Doctor> doctorList= doctorService.findAll();
        model.addAttribute("doctors",doctorList);
        return "doctor/listall";

    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id, Model model) {
        doctorService.delete(id);
        List<Doctor> doctorList = doctorService.findAll();
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
        doctorService.addDoctor(doctor);
        return "redirect:/doctors/list"; // redirect → újratöltés, nincs duplázás
    }

    @GetMapping("/edit/{id}")
    public String editDoctor(@PathVariable("id") int id, Model model) {
        Doctor doctor = doctorService.findByid(id);
        model.addAttribute("doctor", doctor);
        return "doctor/add";
    }
    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model) {
        Doctor doctor = doctorService.findByid(id);
        model.addAttribute("doctor", doctor);
        return "doctor/details";
    }




//    @PostMapping("/add")
//    public String updateDoctor(@ModelAttribute Doctor doctor, Model model){
//        doctorServivee.addDoctor(doctor);
//        List<Doctor> doctorList = doctorServivee.findAll();
//        model.addAttribute("doctors", doctorList);
//        return "doctor/listall";
//
//    }

}
