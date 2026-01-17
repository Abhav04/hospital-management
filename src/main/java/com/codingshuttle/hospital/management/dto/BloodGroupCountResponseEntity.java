package com.codingshuttle.hospital.management.dto;

import com.codingshuttle.hospital.management.entity.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@Data
@ToString
public class BloodGroupCountResponseEntity {

    private BloodGroupType bloodGroupType;
    private Long count;

    public BloodGroupCountResponseEntity(BloodGroupType bloodGroup, Long count){
        this.bloodGroupType = bloodGroup;
        this.count = count;
    }
}
