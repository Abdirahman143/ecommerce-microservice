package com.abdirahman.inventoryservice.service;

import com.abdirahman.inventoryservice.dto.InventoryRequest;
import com.abdirahman.inventoryservice.model.Inventory;
import org.springframework.http.ResponseEntity;

public interface InventoryService {
    ResponseEntity<Inventory> createInventories(InventoryRequest inventoryRequest);

    boolean isInStock(String skuCode);
}
