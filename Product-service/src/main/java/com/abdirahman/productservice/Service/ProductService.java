package com.abdirahman.productservice.Service;

import com.abdirahman.productservice.dto.ProductRequest;
import com.abdirahman.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void CreateProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();
}
