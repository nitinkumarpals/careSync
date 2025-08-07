package com.nitin.pal.careSync.repository;

import com.nitin.pal.careSync.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
}
