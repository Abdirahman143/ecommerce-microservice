package com.abdirahman.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderLineDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
