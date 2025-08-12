package com.nitin.pal.careSync.repository;

import com.nitin.pal.careSync.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
