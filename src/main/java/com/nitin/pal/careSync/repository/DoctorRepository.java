package com.nitin.pal.careSync.repository;

import com.nitin.pal.careSync.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
