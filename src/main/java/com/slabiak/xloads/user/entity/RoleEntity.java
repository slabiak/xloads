package com.slabiak.xloads.user.entity;

import com.slabiak.xloads.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "roles")
public class RoleEntity extends BaseEntity {

    private String name;

}
