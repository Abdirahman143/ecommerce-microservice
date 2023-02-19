package com.abdirahman.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan({"com.abdirahman.inventoryservice.controller",
//        "com.abdirahman.inventoryservice.service",
//        "com.abdirahman.inventoryservice.repository"
//})
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

}
