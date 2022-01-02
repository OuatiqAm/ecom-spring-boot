package com.para.paramiel.dtos.order;

import com.para.paramiel.entities.Orders;
import com.para.paramiel.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemDto {
    private int id;
    private Orders order;
    private Product product;
    private int productSelectedQuantity;

    public OrderItemDto(Product product, int productQuantity) {
        this.product = product;
        this.productSelectedQuantity = productQuantity;
    }

    public OrderItemDto() {
    }
}
