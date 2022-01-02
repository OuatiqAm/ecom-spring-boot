package com.para.paramiel.controllers;

import com.para.paramiel.dtos.users.UserRequestDto;
import com.para.paramiel.dtos.users.UserResponseDto;
import com.para.paramiel.entities.User;
import com.para.paramiel.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto request){

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(request, User.class);
        user.setEncriptedPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        User newUser = userService.createUser(user);
        UserResponseDto response = mapper.map(newUser, UserResponseDto.class);
        return new ResponseEntity<UserResponseDto>(response, HttpStatus.CREATED);
    }

}
