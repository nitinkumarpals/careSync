package com.nitin.pal.careSync.repository;

import com.nitin.pal.careSync.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
