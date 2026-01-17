package com.codingshuttle.hospital.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name="patient",
        uniqueConstraints = {
       // @UniqueConstraint(name="unique_patient_email",columnNames = {"email"}),
        @UniqueConstraint(name="unique_patient_name_birthdate",columnNames = {"name","birthdate"})
        },
        indexes={
                @Index(name="idx_patient_birth_date",columnList = "birth_date")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable=false)
private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group",nullable = false)
    private BloodGroupType bloodGroup;
@Column(name="birth_date")
private LocalDate birthdate;
@Column(unique = true)
private String email;

private String gender;

@OneToOne(cascade= {CascadeType.ALL},orphanRemoval = true)
@JoinColumn(name="patient_insurance_id")
private Insurance insurance;

@OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch=FetchType.EAGER)
private List<Appointment> appointments=new ArrayList<Appointment>();
}
