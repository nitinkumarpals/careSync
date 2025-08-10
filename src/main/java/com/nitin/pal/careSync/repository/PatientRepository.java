package com.nitin.pal.careSync.repository;

import com.nitin.pal.careSync.entity.Patient;
import com.nitin.pal.careSync.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT p FROM Patient p where p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT p.bloodGroup, Count(p) FROM Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupByType();
}
