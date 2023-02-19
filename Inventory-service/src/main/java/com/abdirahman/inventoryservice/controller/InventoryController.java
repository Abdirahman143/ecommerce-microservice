package com.abdirahman.inventoryservice.controller;

import com.abdirahman.inventoryservice.dto.InventoryRequest;
import com.abdirahman.inventoryservice.model.Inventory;
import com.abdirahman.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;




    @PostMapping()
    public ResponseEntity<Inventory>SaveInventory(@RequestBody InventoryRequest inventoryRequest){
        return  inventoryService.createInventories(inventoryRequest);
    }

    @GetMapping("{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable(value = "sku-code")String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
