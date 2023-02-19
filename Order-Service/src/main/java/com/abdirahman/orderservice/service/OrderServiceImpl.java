package com.abdirahman.orderservice.service;

import com.abdirahman.orderservice.dto.OrderLineDto;
import com.abdirahman.orderservice.dto.OrderRequest;
import com.abdirahman.orderservice.model.Order;
import com.abdirahman.orderservice.model.OrderLineItems;
import com.abdirahman.orderservice.repository.OrderLineItemRepository;
import com.abdirahman.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private  final OrderLineItemRepository orderLineItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderLineItemRepository orderLineItemRepository) {
        this.orderRepository = orderRepository;
        this.orderLineItemRepository = orderLineItemRepository;
    }

      @Override
    public Order CreateOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList=
                orderRequest.getOrderLineList().stream().map(this::MapToDto).toList();
        order.setOrderLineList(orderLineItemsList);

        return orderRepository.save(order);
    }

    private OrderLineItems MapToDto(OrderLineDto orderLineDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineDto.getPrice());
        orderLineItems.setSkuCode(orderLineDto.getSkuCode());
        orderLineItems.setPrice(orderLineDto.getPrice());
        orderLineItems.setQuantity(orderLineDto.getQuantity());
        return orderLineItems;
    }


}
