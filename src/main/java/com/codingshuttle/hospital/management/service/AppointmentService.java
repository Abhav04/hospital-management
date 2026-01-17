package com.codingshuttle.hospital.management.service;

import com.codingshuttle.hospital.management.Repository.AppointmentRepository;
import com.codingshuttle.hospital.management.Repository.DoctorRepository;
import com.codingshuttle.hospital.management.Repository.InsuranceRepository;
import com.codingshuttle.hospital.management.Repository.PatientRepository;
import com.codingshuttle.hospital.management.entity.Appointment;
import com.codingshuttle.hospital.management.entity.Doctor;
import com.codingshuttle.hospital.management.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
@Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new RuntimeException("doctor not found"));
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null) throw new IllegalArgumentException("appointment already exists");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

       return appointmentRepository.save( appointment);
    }
    @Transactional
    public Appointment reassignAppointment(Long appointmentid,Long doctorId){
    Appointment appointment=appointmentRepository.findById(appointmentid).orElseThrow(()->new RuntimeException("appointment not found"));
    Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

    appointment.setDoctor(doctor);
    doctor.getAppointments().add(appointment);
    return appointment;
    }
}
