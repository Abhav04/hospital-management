package com.codingshuttle.hospital.management.service;

import com.codingshuttle.hospital.management.Repository.PatientRepository;
import com.codingshuttle.hospital.management.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Patientservice {
    @Autowired
private final PatientRepository patientRepository;
@Transactional

    public Patient getPatientById(Long id){
        Patient p1=patientRepository.findById(id).orElseThrow();
        Patient p2=patientRepository.findById(id).orElseThrow();
    p1.setName("adhip");
return p1;//demonstrates transactional behaviour

    }
}
