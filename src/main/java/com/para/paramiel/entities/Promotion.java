package com.para.paramiel.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private LocalDateTime startDatePromotion;
    private LocalDateTime endDatePromotion;
    private int ratio;
    private BigDecimal amount;
    private BigDecimal minAmount;
    private int minQuantity;
    @Column(columnDefinition = "BOOLEAN default false")
    private boolean active ;
    @OneToMany
    private List<Product> productList;



}
