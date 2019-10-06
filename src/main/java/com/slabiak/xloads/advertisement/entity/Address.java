package com.slabiak.xloads.advertisement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {

    private String street_number;
    private String route;
    private String city;
    private String postal_code;
    private String lat;
    private String lng;

}
