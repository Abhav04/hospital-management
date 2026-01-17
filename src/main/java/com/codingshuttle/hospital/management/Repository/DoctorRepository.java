package com.codingshuttle.hospital.management.Repository;

import com.codingshuttle.hospital.management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}