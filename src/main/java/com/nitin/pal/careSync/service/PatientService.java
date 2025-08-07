package com.nitin.pal.careSync.service;

import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){
        Patient patient1 = patientRepository.findById(id).orElseThrow();
        Patient patient2 = patientRepository.findById(id).orElseThrow();
        return patient1;
    }
}
