package com.para.paramiel.repositories;

import com.para.paramiel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select u from User  u where u.id = :id")
    Optional<User> getUserById(int id);

    @Query("Select u from User  u where u.userId = :userId")
    User getUserByUserId(@Param(value ="userId")String userId);

    @Query("Select u from User u where u.firstName = :firstName")
    List<User> getUserByFirstName(@Param(value ="firstName")String name);

    @Query("Select u from User u where u.email = :email")
    User getUserByEmail(@Param(value ="email")String email);







}
