package com.para.paramiel.repositories;

import com.para.paramiel.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {



    @Query("Delete from OrderItem i where i.product.id = :id")
    void deleteItemByProductId(@Param(value ="id")int id);

}
