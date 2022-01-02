package com.para.paramiel.dtos.users;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserResponseDto {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
