package com.para.paramiel.services;

import com.para.paramiel.dtos.users.UserDto;
import com.para.paramiel.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService  extends UserDetailsService {

    Optional<User> findUserById(int id);
    List<User> findUserByFirstName(String name);
    List<User> findAllUser();
    User findUserByEmail(String email);
    User findUserByUserId(String userId);
    User createUser(User user);


    
}
