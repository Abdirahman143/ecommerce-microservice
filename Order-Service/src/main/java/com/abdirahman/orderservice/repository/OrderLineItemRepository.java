package com.abdirahman.orderservice.repository;

import com.abdirahman.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItems,Long> {
}
