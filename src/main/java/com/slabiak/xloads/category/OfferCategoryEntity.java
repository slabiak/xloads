package com.slabiak.xloads.category;

import com.slabiak.xloads.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "categories")
public class OfferCategoryEntity extends BaseEntity {

    String name;
}
