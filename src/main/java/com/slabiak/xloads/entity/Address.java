package com.slabiak.xloads.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "address")
public class Address extends BaseEntity {

    private String street_number;
    private String route;
    private String city;
    private String postal_code;
    private String lat;
    private String lng;

}
