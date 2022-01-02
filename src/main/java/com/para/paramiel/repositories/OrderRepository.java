package com.para.paramiel.repositories;


import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query("Select o from Orders  o where o.id = :id")
    Orders getOrderById(Integer id);

    @Query("Select i from OrderItem as i where i.order.id= :id")
    List<OrderItem> getOrderItemsByOrderId(@Param(value ="id")Integer id);

    @Query("Select i from OrderItem as i where i.order= :o")
    List<OrderItem> getOrderItemsByOrder(@Param(value ="o")Orders o);

    @Query("Select o from Orders  o where o.reference = :reference")
    Orders getOrderByReference(@Param(value = "reference") String reference);

}
