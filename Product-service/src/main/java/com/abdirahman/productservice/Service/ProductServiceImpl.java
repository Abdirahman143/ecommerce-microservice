package com.abdirahman.productservice.Service;


import com.abdirahman.productservice.dto.ProductRequest;
import com.abdirahman.productservice.dto.ProductResponse;
import com.abdirahman.productservice.model.Product;
import com.abdirahman.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

       @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void CreateProduct(ProductRequest productRequest){
        Product product = Product
                .builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
         productRepository.save(product);
         log.info("product {} is saved on the database",product.getId());
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product>products = productRepository.findAll();
        return products.stream().map(this::MapToProducts).toList();
    }

    private ProductResponse MapToProducts(Product product) {
           return ProductResponse
                   .builder()
                   .id(product.getId())
                   .name(product.getName())
                   .description(product.getDescription())
                   .price(product.getPrice())
                   .build();
    }
}
