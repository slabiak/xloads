package com.slabiak.xloads.advertisement.dto;

import com.slabiak.xloads.geocoding.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisementCreateDTO {

    private String title;
    private String description;
    private double price;
    private Address address;
}
