package com.slabiak.xloads.position;

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

    private String streetNumber;
    private String route;
    private String city;
    private String postalCode;

    @Override
    public String toString() {
        return postalCode + " " + city + ", " + route + " " + streetNumber;
    }
}
