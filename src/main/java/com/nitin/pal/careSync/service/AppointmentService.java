package com.nitin.pal.careSync.service;

import com.nitin.pal.careSync.entity.Appointment;
import com.nitin.pal.careSync.entity.Doctor;
import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.repository.AppointmentRepository;
import com.nitin.pal.careSync.repository.DoctorRepository;
import com.nitin.pal.careSync.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have id");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);// just to maintain bidirectional consistency
        doctor.getAppointments().add(appointment);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);// this will automatically call the update, because it is dirty now
        doctor.getAppointments().add(appointment);//just for bidirectional consistency
        return appointment;
    }
}
