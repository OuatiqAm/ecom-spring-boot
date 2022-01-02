package com.para.paramiel.dtos.product;

import com.para.paramiel.entities.Category;
import com.para.paramiel.entities.Media;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class ProductRequestDto {

    @NotNull
    private  String name;
    @NotNull
    private String skuCode;
    @NotNull
    @Digits(integer = 6, fraction =2 )
    private BigDecimal price;
    @NotNull
    @Min(10) // min quantity requiered
    private int quantity;
    @NotNull
    private String description;
    private List<Media> mediaList;
    private Category category;


}
