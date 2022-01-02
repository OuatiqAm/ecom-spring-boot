package com.para.paramiel.services;

import com.para.paramiel.entities.OrderStatus;
import com.para.paramiel.entities.Orders;
import com.para.paramiel.repositories.OrderItemRepository;
import com.para.paramiel.repositories.OrderRepository;
import com.para.paramiel.repositories.ProductRepository;
import com.para.paramiel.repositories.UserRepository;
import com.para.paramiel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Orders findOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public Orders findOrderByReference(String reference) {
        return orderRepository.getOrderByReference(reference);
    }

    @Override
    public List<Orders> findOrderByStatus(OrderStatus status) {
        return null;//orderRepository.getOrderByStatus(String.valueOf(status));
    }

    @Override
    public List<Orders> findAllOrder() {
        return orderRepository.findAll();
    }



    @Override
    public Orders addOrder(Orders order) {

        order.setOrderStatus(OrderStatus.CREATED);
        order.setCreationDateTime(LocalDateTime.now());
        order.setReference(Utils.generateOrderRef());

        Orders newOrder = orderRepository.save(order);

       return newOrder;
    }



    @Override
    public Orders updateOrder(Orders order) {
        Orders updateOrder = orderRepository.save(order);
        return updateOrder;
    }


}
