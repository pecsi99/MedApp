package org.example.controller;

import jakarta.transaction.Transactional;
import org.example.model.Doctor;
import org.example.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

//    public DoctorController(DoctorService doctorService)  {
//        this.doctorService = doctorService;
//    }

    @GetMapping("/index")
    public String showHomePage(Model model) {
        return "index";

    }
    @GetMapping("/list")
    public String findAll(Model model) {
        List<Doctor> doctorList = doctorService.findAll();
        model.addAttribute("doctors", doctorList);
        return "doctor/listall";

    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id, Model model) {
        doctorService.delete(id);
//        List<Doctor> doctorList = doctorService.findAll();
//        model.addAttribute("doctors", doctorList);
        return "redirect:/doctors/list";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/add";
    }


    @PostMapping("/add")
    @Transactional
    public String addDoctor(@ModelAttribute("doctor") Doctor updatedDoctor) {
        // Ha ID = 0 → ÚJ orvos → egyszerű mentés
        if (updatedDoctor.getId() == 0) {
            doctorService.addDoctor(updatedDoctor);
            return "redirect:/doctors/list";
        }

        // LÉTEZŐ orvos → FRISSÍTÉS
        Doctor existingDoctor = doctorService.findByid(updatedDoctor.getId());
        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setDepartment(updatedDoctor.getDepartment());

        doctorService.addDoctor(existingDoctor);
        return "redirect:/doctors/list";
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


}
