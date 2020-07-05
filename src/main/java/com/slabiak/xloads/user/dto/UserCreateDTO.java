package com.slabiak.xloads.user.dto;

import com.slabiak.xloads.offer.model.Address;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreateDTO {
    private String username;
    private String password;
    private String repeatPassword;
    private String email;
    private String repeatEmail;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
}
