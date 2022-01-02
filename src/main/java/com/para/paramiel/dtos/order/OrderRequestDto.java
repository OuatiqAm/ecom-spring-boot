package com.para.paramiel.dtos.order;

import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.entities.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class OrderRequestDto {

    private LocalDateTime creationDateTime;
    private LocalDateTime  closeDateTime;
    private OrderStatus orderStatus;
    private BigDecimal totalPrice;
    private String customer;
    private List<OrderItem> orderItems;
}
