package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/appointment")
    public String getAllAppointments(Model model) {
        List<Appointment> appointment = appointmentService.getAllAppointments();
        System.out.println(appointment);
        model.addAttribute("appointment", appointment);
        return "appointment-list";
    }

    @GetMapping("/appointment/{username}")
    public String getAppointmentsById(@PathVariable String username, Model model) {
        System.out.println(username);
        List<Appointment> appointment = appointmentService.getAppointmentByClientId(username);
        System.out.println(appointment);
        model.addAttribute("appointment", appointment);
        return "appointment-list";
    }

    @GetMapping("/appointment/edit/{id}")
    public String showEditAppointmentForm(@PathVariable Long id, Model model) {
        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentById(id);
        if (optionalAppointment.isPresent()) {
            model.addAttribute("appointment", optionalAppointment.get());
            deleteAppointment(id,optionalAppointment.get());
        } else {
            return "redirect:/appointment";
        }
        return "appointment-form";
    }

    @GetMapping("/appointment/new")
    public String showCreateAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment-form";
    }

    @PostMapping("/appointment/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        if (appointment.getId() != null) {
            appointmentService.updateAppointment(appointment.getId(), appointment);
        } else {
            appointmentService.saveAppointment(appointment);
        }
        return "redirect:/appointment/" + appointment.getClientid();
    }

    @GetMapping("/appointment/delete/{id}")
    public String deleteAppointment(@PathVariable Long id,@ModelAttribute("appointment") Appointment appointment) {
        Optional<Appointment> optionalAppointment = appointmentService.getAppointmentById(id);
        String clientId = null;
        if (optionalAppointment.isPresent()) {
            clientId = optionalAppointment.get().getClientid();
        }
        appointmentService.deleteAppointment(id);
        return "redirect:/appointment/"  + clientId;
    }

}
