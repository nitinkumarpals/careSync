package com.nitin.pal.careSync;

import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.repository.PatientRepository;
import com.nitin.pal.careSync.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(27L);
        Patient patient= patientRepository.findByName("Diya Patel");
        System.out.println(patient);
    }
}
