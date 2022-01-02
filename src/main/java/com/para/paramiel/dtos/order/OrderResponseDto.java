package com.para.paramiel.dtos.order;

import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.entities.OrderStatus;
import com.para.paramiel.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class OrderResponseDto {

    private int id;
    private String reference;
    private LocalDateTime creationDateTime;
    private LocalDateTime  closeDateTime;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private User customer;
}
