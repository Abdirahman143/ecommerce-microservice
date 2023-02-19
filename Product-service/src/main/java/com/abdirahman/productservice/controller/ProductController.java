package com.abdirahman.productservice.controller;

import com.abdirahman.productservice.Service.ProductService;
import com.abdirahman.productservice.dto.ProductRequest;
import com.abdirahman.productservice.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
 public void SaveProduct(@RequestBody ProductRequest productRequest){
        productService.CreateProduct(productRequest);
 }

 @GetMapping("/all")
 @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>getAllProduct(){
        return productService.getProducts();
 }

}
