package com.para.paramiel.controllers;

import com.para.paramiel.dtos.order.OrderResponseDto;
import com.para.paramiel.dtos.order.OrderRequestDto;
import com.para.paramiel.entities.OrderItem;
import com.para.paramiel.entities.OrderStatus;
import com.para.paramiel.entities.Orders;
import com.para.paramiel.entities.User;
import com.para.paramiel.exceptions.ItemsNotFoundException;

import com.para.paramiel.services.OrderItemService;
import com.para.paramiel.services.OrderService;
import com.para.paramiel.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemService;


    @PostMapping
    public ResponseEntity<OrderResponseDto> addOrder(@RequestBody OrderRequestDto orderRequestDto){

        ModelMapper mapper = new ModelMapper();
        Orders order = mapper.map(orderRequestDto, Orders.class);
        String customerId = orderRequestDto.getCustomer();
        User customer = userService.findUserByUserId(customerId);
        if(customer == null) throw new ItemsNotFoundException("Customer not found");
        order.setCustomer(customer);

        order.getOrderItems().stream().forEach(i->{
            i.setOrder(order);
        });
        Orders newOrder = orderService.addOrder(order);

        OrderResponseDto orderGetDto = mapper.map(newOrder, OrderResponseDto.class);

        return  new ResponseEntity<OrderResponseDto>(orderGetDto, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public  ResponseEntity<OrderResponseDto> updateOrder(@PathVariable int orderId, @RequestBody OrderRequestDto request){
        Orders order = orderService.findOrderById(orderId);
        if(order == null) throw new NullPointerException("Order not found");
        order.setOrderStatus(request.getOrderStatus());
        if(order.getOrderStatus() == OrderStatus.CLOSED)
        order.setCloseDateTime(LocalDateTime.now());
        List<OrderItem> items = request.getOrderItems();
        order.setOrderItems(items);
        items.forEach(i->i.setOrder(order));
        Orders newOrder = orderService.updateOrder(order);
        ModelMapper mapper = new ModelMapper();
        OrderResponseDto orderGetDto = mapper.map(newOrder, OrderResponseDto.class);
        return new ResponseEntity<OrderResponseDto>(orderGetDto, HttpStatus.ACCEPTED);
    }




    @GetMapping(path = "/{reference}")
    public ResponseEntity<OrderResponseDto> getOrderByReference(@PathVariable String reference){
        Orders order = orderService.findOrderByReference(reference);
        if(order == null) throw new ItemsNotFoundException("Order not found");
        ModelMapper mapper = new ModelMapper();
        OrderResponseDto orderGetDto = mapper.map(order, OrderResponseDto.class);
        return new ResponseEntity<OrderResponseDto>(orderGetDto,HttpStatus.OK);
    }

    @DeleteMapping(path="/item/{ref}")
    public ResponseEntity<Object> removeItem(@PathVariable String ref) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
