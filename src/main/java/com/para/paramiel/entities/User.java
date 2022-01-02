package com.para.paramiel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String adress;

    @Column
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    private String encriptedPassword;
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY) // relation bi-directionnel mapped by user ID
    @JsonIgnore
    private List<Orders> orderList;



}
