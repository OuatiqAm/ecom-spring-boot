package com.para.paramiel.services;

import com.para.paramiel.dtos.users.UserDto;
import com.para.paramiel.exceptions.AlreadyExistException;
import com.para.paramiel.exceptions.ItemsNotFoundException;
import com.para.paramiel.repositories.UserRepository;
import com.para.paramiel.entities.User;
import com.para.paramiel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service(value = "userServiceImpl")
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> findUserByFirstName(String name) {
        return userRepository.getUserByFirstName(name);
    }



    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        if(user == null) throw new UsernameNotFoundException("User with "+email+" not found");
        return user;
    }

    @Override
    public User findUserByUserId(String userId) {
        User user = userRepository.getUserByUserId(userId);
        if(user == null ) throw new ItemsNotFoundException("User with user_id "+userId+" not found");
        return user;
    }

    @Override
    public User createUser(User user) throws  AlreadyExistException{

        User checkUser = userRepository.getUserByEmail(user.getEmail());
        if(checkUser != null ) throw new AlreadyExistException(user.getEmail());
        user.setUserId(Utils.generateId());
        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if(user == null) throw new UsernameNotFoundException("User with Email: "+email+" not found");


        return new org.springframework.security.core.userdetails
                .User(user.getEmail(), user.getEncriptedPassword(), new ArrayList());
    }
}
