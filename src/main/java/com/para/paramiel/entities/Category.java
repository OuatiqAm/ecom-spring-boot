package com.para.paramiel.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.para.paramiel.entities.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


}
