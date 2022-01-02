package com.para.paramiel.services;

import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem addOrderItem(OrderItem item) {
        return orderItemRepository.save(item);
    }


}
