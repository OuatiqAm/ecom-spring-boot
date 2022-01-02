package com.para.paramiel.dtos.product;

import com.para.paramiel.entities.Category;
import com.para.paramiel.entities.Media;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductResponseDto {

    private int id;
    private  String name;
    private String skuCode;
    private BigDecimal price;
    private int quantity;
    private String description;
    private List<Media> mediaList;
    private Category category;
}
