package com.abdirahman.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "products")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(String name,
                   String description,
                   BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }



}
