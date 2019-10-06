package com.slabiak.xloads.advertisement.dto;

import com.slabiak.xloads.position.Address;
import com.slabiak.xloads.position.AddressPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisementReadDTO {
    private int id;
    private int ownerId;
    private String title;
    private String description;
    private double price;
    private Address address;
    private AddressPosition addressPosition;
}
