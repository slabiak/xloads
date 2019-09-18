package com.slabiak.xloads.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonDeserialize(builder = User.UserBuilder.class)
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "owner")
    List<Advertisement> advertisements;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class UserBuilder {
    }


}
