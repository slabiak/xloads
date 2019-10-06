package com.slabiak.xloads.user.dto;

import com.slabiak.xloads.geocoding.Address;
import com.slabiak.xloads.geocoding.GeocodingApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReadDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
    private GeocodingApiResponse addressPosition;
}
