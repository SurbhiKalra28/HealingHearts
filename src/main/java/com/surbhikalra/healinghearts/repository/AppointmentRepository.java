package com.surbhikalra.healinghearts.repository;

import com.surbhikalra.healinghearts.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByClientid(String clientid);

    List<Appointment> findAppointmentByClientname(String clientname);


    List<Appointment> findAppointmentByAppointmentwith(String appointmentwith);
}
