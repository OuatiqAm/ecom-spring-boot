package com.para.paramiel.dtos.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
