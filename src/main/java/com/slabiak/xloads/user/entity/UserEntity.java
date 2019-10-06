package com.slabiak.xloads.user.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.slabiak.xloads.advertisement.entity.AdvertisementEntity;
import com.slabiak.xloads.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonDeserialize(builder = UserEntity.UserBuilder.class)
public class UserEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "owner")
    List<AdvertisementEntity> advertisementEntities;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class UserBuilder {
    }


}