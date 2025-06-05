package org.example.controller;

import jakarta.transaction.Transactional;
import org.example.model.Appointment;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.AppointmentService;
import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;
    private DoctorService doctorService;
    private PatientService patientService;

    public AppointmentController(AppointmentService appointmentService, DoctorService doctorService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("")
    public String findAll(Model model){
        List<Appointment> appointments = appointmentService.findAll();
        model.addAttribute("appointments",appointments);
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
    public String bookAppointment(@PathVariable("id") int appointmentId, @RequestParam("patientId") int patientId) {
        Appointment appointment = appointmentService.findByid(appointmentId);
        Doctor doctor = appointment.getDoctor();
        Patient patient = patientService.findByid(patientId);

        appointment.setPatient(patient);
        doctor.getAppointments().add(appointment);
        patient.getAppointments().add(appointment);

        doctorService.addDoctor(doctor);
        patientService.addPatient(patient);

//        appointmentService.deleteByid(appointmentId);
        return "redirect:/appointment";
    }
}


