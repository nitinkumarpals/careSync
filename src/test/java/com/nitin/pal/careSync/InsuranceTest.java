package com.nitin.pal.careSync;

import com.nitin.pal.careSync.entity.Appointment;
import com.nitin.pal.careSync.entity.Insurance;
import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.service.AppointmentService;
import com.nitin.pal.careSync.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        Patient disaccociatedPatient = insuranceService.disaccociateInsuranceFromPatient(patient.getId());
        System.out.println(disaccociatedPatient);
    }

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment
                .builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0))
                .reason("Headache")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
        System.out.println(newAppointment);

        Appointment updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }
}
