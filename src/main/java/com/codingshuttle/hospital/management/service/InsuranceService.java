package com.codingshuttle.hospital.management.service;

import com.codingshuttle.hospital.management.Repository.InsuranceRepository;
import com.codingshuttle.hospital.management.Repository.PatientRepository;
import com.codingshuttle.hospital.management.entity.BloodGroupType;
import com.codingshuttle.hospital.management.entity.Insurance;
import com.codingshuttle.hospital.management.entity.Patient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;

@Transactional
    public Patient assigninsurancetopatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient not found"+patientId));
patient.setInsurance(insurance);
    if (patient.getBloodGroup() == null) {
        patient.setBloodGroup(BloodGroupType.A_POSITIVE);
    }
    
insurance.setPatient(patient);

        return patient;
    }
    @Transactional
    public Patient disassociateinsurancetopatient(Long patientId){
    Patient patient=patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("patient not found"+patientId));
patient.setInsurance(null);
return patient;

    }

}
