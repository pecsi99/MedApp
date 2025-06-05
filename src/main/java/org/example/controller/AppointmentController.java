package org.example.controller;

import jakarta.transaction.Transactional;
import org.example.model.Appointment;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.AppointmentService;
import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public String findAll(Model model) {
        List<Appointment> appointments = appointmentService.findAll();
        model.addAttribute("appointments", appointments);
        return "appointment/listall";
    }
    @GetMapping("/booking/{id}")
    public String showBookingForm(@PathVariable("id") int id, Model model) {
        Appointment appointment = appointmentService.findByid(id);
        model.addAttribute("appointment", appointment);
        return "appointment/booking";
    }
    @PostMapping("/book/{id}")
    @Transactional
    public String bookAppointment(@PathVariable("id") int appointmentId,
                                  @RequestParam("patientId") int patientId) {
        Appointment appointment = appointmentService.findByid(appointmentId);
        Doctor doctor = appointment.getDoctor();
        Patient patient = patientService.findByid(patientId);

        appointment.setPatient(patient);
//        doctor.getAppointments().add(appointment);
        patient.getAppointments().add(appointment);

        doctorService.addDoctor(doctor);
        patientService.addPatient(patient);

        return "redirect:/appointment";
    }
    @GetMapping("/create")
    public String showCreateForm() {
        return "appointment/create";
    }
    @PostMapping("/create")
    @Transactional
    public String createAppointment(@RequestParam("doctorId") int doctorId,
                                    @RequestParam("dateTime") String dateTime) {
        Doctor doctor = doctorService.findByid(doctorId);
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setDate(LocalDateTime.parse(dateTime));
        appointmentService.save(appointment);
        return "redirect:/appointment";
    }

    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable("id") int id, Model model) {
        appointmentService.deleteByid(id);
        return "redirect:/appointment";

    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Appointment appointment = appointmentService.findByid(id);
        model.addAttribute("appointment", appointment);
        return "appointment/edit";
    }

    @PostMapping("/edit/{id}")
    @Transactional
    public String updateAppointment(@PathVariable("id") int id,
                                    @RequestParam("doctorId") int doctorId,
                                    @RequestParam("dateTime") String dateTime) {
        Appointment appointment = appointmentService.findByid(id);
        Doctor doctor = doctorService.findByid(doctorId);

        appointment.setDoctor(doctor);
        appointment.setDate(LocalDateTime.parse(dateTime));
        appointmentService.save(appointment);

        return "redirect:/appointment";
    }



}


