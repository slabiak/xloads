package com.slabiak.xloads.user.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.slabiak.xloads.advertisement.entity.AdvertisementEntity;
import com.slabiak.xloads.entity.BaseEntity;
import com.slabiak.xloads.geocoding.Address;
import com.slabiak.xloads.geocoding.GeocodingApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
@JsonDeserialize(builder = UserEntity.UserBuilder.class)
public class UserEntity extends BaseEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String encodedPassword;
    private String phone;
    private String email;

    @Embedded
    private Address address;

    @Embedded
    private GeocodingApiResponse addressPosition;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> roles;

    @OneToMany(mappedBy = "owner")
    List<AdvertisementEntity> advertisementEntities;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class UserBuilder {
    }


}
