package com.codingshuttle.hospital.management.Repository;

import com.codingshuttle.hospital.management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}