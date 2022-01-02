package com.para.paramiel.dtos.users;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDto {

    private int id;
    private String userId;
    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;
    private String encryptedPassword;

}
