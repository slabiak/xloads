package com.slabiak.xloads.dto;

import com.slabiak.xloads.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AdvertisementDTO {

    private int id;
    private int ownerId;
    private String title;
    private String description;
    private double price;
    private Address address;
}
