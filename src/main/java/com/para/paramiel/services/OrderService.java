package com.para.paramiel.services;

import com.para.paramiel.entities.OrderStatus;
import com.para.paramiel.entities.Orders;

import java.util.List;

public interface OrderService {

   
    Orders findOrderById(int id);

    Orders findOrderByReference(String reference);

    List<Orders> findOrderByStatus(OrderStatus status);

    List<Orders> findAllOrder();

    Orders addOrder(Orders order);

    Orders updateOrder(Orders order);


}
