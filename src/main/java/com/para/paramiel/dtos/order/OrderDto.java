package com.para.paramiel.dtos.order;

import com.para.paramiel.dtos.users.UserDto;
import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.entities.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class OrderDto {

    private int id;
    private String orderReference;
    private LocalDateTime creationDateTime;
    private LocalDateTime  closeDateTime;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private String customer;
    private UserDto client;


}
