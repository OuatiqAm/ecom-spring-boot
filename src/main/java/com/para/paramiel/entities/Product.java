package com.para.paramiel.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String skuCode;
    private  String name;
    private BigDecimal price;
    private int quantity;
    private String description;
    @OneToMany
    private List<Media> mediaList;
    @ManyToOne
    private Category category;
/**
    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItem> orderItems;   */



}
