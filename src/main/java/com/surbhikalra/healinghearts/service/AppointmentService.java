package com.surbhikalra.healinghearts.service;

import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }


    public List<Appointment> getAppointmentByClientId(String clientid) {return appointmentRepository.findAppointmentByClientid(clientid);
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setClientid(updatedAppointment.getClientid());
                    appointment.setClientname(updatedAppointment.getClientname());
                    appointment.setAppointmentwith(updatedAppointment.getAppointmentwith());
                    appointment.setType(updatedAppointment.getType());
                    appointment.setDate(updatedAppointment.getDate());
                    appointment.setTime(updatedAppointment.getTime());
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

}

