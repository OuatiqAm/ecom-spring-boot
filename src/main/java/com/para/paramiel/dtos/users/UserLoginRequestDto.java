package com.para.paramiel.dtos.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDto {

    private String email;
    private String password;
}
