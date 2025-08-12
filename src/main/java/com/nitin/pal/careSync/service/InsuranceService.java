package com.nitin.pal.careSync.service;

import com.nitin.pal.careSync.entity.Insurance;
import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.repository.InsuranceRepository;
import com.nitin.pal.careSync.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient with id: " + patientId + " not found"));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);// bidirectional consistency maintenance in case we use insurance letter in this scope
        return patient;
    }
}
