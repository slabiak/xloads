package com.slabiak.xloads.advertisement.entity;

import com.slabiak.xloads.entity.BaseEntity;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "advertisement")
public class AdvertisementEntity extends BaseEntity {

    private double price;
    private LocalDateTime created;
    private String title;
    private String description;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

}
