package com.slabiak.xloads.offer.dto;

import com.slabiak.xloads.offer.model.Address;
import com.slabiak.xloads.offer.model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferReadDTO {
    private int id;
    private int ownerId;
    private List<String> images;
    private LocalDateTime created;

    private String title;
    private String description;
    private int price;
    private Address address;
    private Coordinates coordinates;
}
