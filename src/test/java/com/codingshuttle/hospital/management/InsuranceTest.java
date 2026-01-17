package com.codingshuttle.hospital.management;

import com.codingshuttle.hospital.management.Repository.DoctorRepository;
import com.codingshuttle.hospital.management.entity.Appointment;
import com.codingshuttle.hospital.management.entity.Doctor;
import com.codingshuttle.hospital.management.entity.Insurance;
import com.codingshuttle.hospital.management.entity.Patient;
import com.codingshuttle.hospital.management.service.AppointmentService;
import com.codingshuttle.hospital.management.service.InsuranceService;
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
    public void test(){
        Insurance insurance = Insurance.builder().
                policyNumber("HDFC_1234"+ System.currentTimeMillis())
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

       Patient patient= insuranceService.assigninsurancetopatient(insurance,1L);
       System.out.println(patient) ;
       var newPatient=insuranceService.disassociateinsurancetopatient(patient.getId());
       System.out.println(newPatient);
    }
@Autowired
private DoctorRepository doctorRepository;
@Test
public void testCreateAppointment(){
    Doctor doctor = Doctor.builder()
            .name("Dr John")
            .email("john_" + System.currentTimeMillis() + "@hospital.com")
            .specialization("Cancer")
            .build();

    doctor =doctorRepository.save(doctor);
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,12,12,12,12))
                .reason("cancer")
                .build();
        var newAppointment=appointmentService.createNewAppointment(appointment, doctor.getId(), 2L);
    System.out.println(newAppointment);
    var updatedAppointment=appointmentService.reassignAppointment(newAppointment.getId(), doctor.getId());
    System.out.println(updatedAppointment);
}


}