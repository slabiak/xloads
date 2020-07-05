package com.slabiak.xloads.offer.dto;

import com.slabiak.xloads.offer.model.Address;
import com.slabiak.xloads.offer.model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferCreateDTO {

    private String name;
    private String description;
    private double price;
    private Address address;
    private Coordinates coordinates;
}
