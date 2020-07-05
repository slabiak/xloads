package com.slabiak.xloads.user.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.slabiak.xloads.entity.BaseEntity;
import com.slabiak.xloads.offer.entity.OfferEntity;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> roles;

    @OneToMany(mappedBy = "owner")
    List<OfferEntity> advertisementEntities;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class UserBuilder {
    }

}
