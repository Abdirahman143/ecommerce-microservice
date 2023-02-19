package com.abdirahman.orderservice.service;

import com.abdirahman.orderservice.dto.OrderRequest;
import com.abdirahman.orderservice.model.Order;

public interface OrderService {

    Order CreateOrder(OrderRequest orderRequest);
}
