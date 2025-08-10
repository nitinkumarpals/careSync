package com.nitin.pal.careSync;

import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.entity.type.BloodGroupType;
import com.nitin.pal.careSync.repository.PatientRepository;
import com.nitin.pal.careSync.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
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
//        Patient patient= patientRepository.findByName("Diya Patel");
        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"kabir.singh@example.com" );
        System.out.println(patientList);
//        List<Patient> patientList2 = patientRepository.findByBornAfterDate(LocalDate.of(1993,3,14));
        List<Object[]> bloodGroupByTypeList = patientRepository.countEachBloodGroupByType();
        for (Object[] patient: bloodGroupByTypeList){
            System.out.println(patient[0]+" "+ patient[1]);
        }
    }
}
