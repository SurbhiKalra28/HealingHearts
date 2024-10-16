package com.surbhikalra.healinghearts.controller;

import com.surbhikalra.healinghearts.exception.AppointmentNotFoundException;
import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Appointment Controller class to handle all appointment related request
@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //Get all appointments
    @GetMapping("/appointment")
    public String getAllAppointments(Model model) {
        List<Appointment> appointment = appointmentService.getAllAppointments();
        model.addAttribute("appointment", appointment);
        return "appointment-list";
    }

    //Get all appointments by client
    @GetMapping("/appointment/{username}")
    public String getAppointmentByClientId(@PathVariable String username, Model model) {
        List<Appointment> appointment = appointmentService.getAppointmentByClientId(username);
        model.addAttribute("appointment", appointment);
        return "appointment-list";
    }

    //Get appointment by its id
    @GetMapping("/appointment/error/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + id + " not found"));
    }

    //Get data for the appointment that needs to be edited
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

    //Handle request for a new appointment booking
    @GetMapping("/appointment/new")
    public String showCreateAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment-form";
    }

    //Create new appointment in the model
    @PostMapping("/appointment/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        if (appointment.getId() != null) {
            appointmentService.updateAppointment(appointment.getId(), appointment);
        } else {
            appointmentService.saveAppointment(appointment);
        }
        return "redirect:/appointment/" + appointment.getClientid();
    }

    //Delete the existing appointment
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
