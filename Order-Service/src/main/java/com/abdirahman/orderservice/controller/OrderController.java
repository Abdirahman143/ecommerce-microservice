package com.abdirahman.orderservice.controller;

import com.abdirahman.orderservice.dto.OrderRequest;
import com.abdirahman.orderservice.model.Order;
import com.abdirahman.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

private final OrderService orderService;
     @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Order SaveOrder(@RequestBody OrderRequest orderRequest){
        return orderService.CreateOrder(orderRequest);
    }
}
