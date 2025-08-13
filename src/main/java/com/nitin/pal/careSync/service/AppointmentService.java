package com.nitin.pal.careSync.service;

import com.nitin.pal.careSync.repository.AppointmentRepository;
import com.nitin.pal.careSync.repository.DoctorRepository;
import com.nitin.pal.careSync.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
}
