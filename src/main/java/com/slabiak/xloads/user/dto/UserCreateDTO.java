package com.slabiak.xloads.user.dto;

import com.slabiak.xloads.position.Address;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreateDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
}
