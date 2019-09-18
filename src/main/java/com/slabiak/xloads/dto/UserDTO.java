package com.slabiak.xloads.dto;

import com.slabiak.xloads.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
}
