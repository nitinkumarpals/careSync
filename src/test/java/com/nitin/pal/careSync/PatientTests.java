package com.nitin.pal.careSync;

import com.nitin.pal.careSync.dto.BloodGroupCountResponseEntity;
import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.entity.type.BloodGroupType;
import com.nitin.pal.careSync.repository.PatientRepository;
import com.nitin.pal.careSync.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"kabir.singh@example.com" );
//        System.out.println(patientList);
////        List<Patient> patientList2 = patientRepository.findByBornAfterDate(LocalDate.of(1993,3,14));
//        List<Object[]> bloodGroupByTypeList = patientRepository.countEachBloodGroupByType();
//        for (Object[] patient: bloodGroupByTypeList){
//            System.out.println(patient[0]+" "+ patient[1]);
//        }
//        List<Patient> allPatient = patientRepository.findAllPatient();
//        for (Patient patient: allPatient){
//            System.out.println(patient);
//        }
        int rowsUpdated = patientRepository.updateNameWithId("Arav sharma",28L);
        System.out.println(rowsUpdated);

        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupByType();
        for (BloodGroupCountResponseEntity bloodGroupCountResponseEntity: bloodGroupList){
            System.out.println(bloodGroupCountResponseEntity);
        }

        Page<Patient> allPatient = patientRepository.findAllPatient(PageRequest.of(0, 2, Sort.by("name")));
        for (Patient patient: allPatient){
            System.out.println(patient);
        }
    }
}
