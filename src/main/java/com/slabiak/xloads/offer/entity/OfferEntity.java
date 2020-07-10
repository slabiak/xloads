package com.slabiak.xloads.offer.entity;

import com.slabiak.xloads.category.OfferCategoryEntity;
import com.slabiak.xloads.entity.BaseEntity;
import com.slabiak.xloads.offer.model.Address;
import com.slabiak.xloads.offer.model.Coordinates;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "offers")
public class OfferEntity extends BaseEntity {

    private double price;
    private LocalDateTime created;
    private String title;
    private String description;

    @ElementCollection
    private List<String> images;

    @Embedded
    private Address address;

    @Embedded
    private Coordinates coordinates;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private OfferCategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

}
