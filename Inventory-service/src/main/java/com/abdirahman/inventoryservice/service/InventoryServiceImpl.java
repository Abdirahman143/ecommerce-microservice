package com.abdirahman.inventoryservice.service;

import com.abdirahman.inventoryservice.dto.InventoryRequest;
import com.abdirahman.inventoryservice.model.Inventory;
import com.abdirahman.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<Inventory>createInventories(InventoryRequest inventoryRequest){
        Inventory inventory = new Inventory();
        inventory.setSkuCode(inventoryRequest.getSkuCode());
        inventory.setQuantity(inventoryRequest.getQuantity());
        return  new ResponseEntity<>(inventoryRepository.save(inventory), HttpStatus.CREATED);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }



}
