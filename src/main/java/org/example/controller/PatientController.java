package org.example.controller;

import jakarta.transaction.Transactional;
import org.example.model.Patient;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("list")
    public String listAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient/listall";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id, Model model) {
        patientService.deleteById(id);
        return "redirect:/patients/list";

    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add";
    }

    @PostMapping("/add")
    @Transactional
    public String saveOrUpdatePatient(
            @ModelAttribute("patient") Patient updatedPatient) {
        if (updatedPatient.getId() == 0) {
            patientService.addPatient(updatedPatient);
            return "redirect:/patients/list";
        }

        Patient existingPatient =
                patientService.findByid(updatedPatient.getId());
        existingPatient.setName(updatedPatient.getName());

        patientService.addPatient(existingPatient);
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
