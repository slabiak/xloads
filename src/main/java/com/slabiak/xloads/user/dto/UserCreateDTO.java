package com.slabiak.xloads.user.dto;

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
}
