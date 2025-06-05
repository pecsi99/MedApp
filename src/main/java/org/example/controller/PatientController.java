package org.example.controller;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("list")
    public String listAll(Model model){
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients",patients);
        return "patient/listall";

    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id, Model model)
    {
        patientService.deleteById(id);
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients",patients);
        return "patient/listall";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add"; // ha a fájlod neve: templates/patient/add.html
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient){
        patientService.addPatient(patient);
        return "redirect:/patients/list";
    }
    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findByid(id);
        model.addAttribute("patient", patient);
        return "patient/add";
    }
    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findByid(id);
        model.addAttribute("patient", patient);
        return "patient/patientdetails";
    }
}
