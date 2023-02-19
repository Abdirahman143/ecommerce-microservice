package com.abdirahman.productservice.controller;

import com.abdirahman.productservice.Service.ProductService;
import com.abdirahman.productservice.dto.ProductRequest;
import com.abdirahman.productservice.dto.ProductResponse;
import com.abdirahman.productservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductControllerTest {
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;


    @Autowired
   private ObjectMapper objectMapper;

@DynamicPropertySource
    public static void SetProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
    dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
}



@Test
    public void ShouldCreatProduct() throws Exception {
    //given

    ProductRequest productRequest=  getProductRequest();
    String productRequestString = objectMapper.writeValueAsString(productRequest);
    //when //then
    mockMvc.perform(post("/api/v1/product")
            .contentType(MediaType.APPLICATION_JSON)
            .content(productRequestString))
            .andExpect(status().isCreated());

    assertEquals(1,productRepository.findAll().size());
}

    private ProductRequest getProductRequest() {
         return  ProductRequest
                 .builder()
                 .name("SamSun A13")
                 .description("New SumSung model")
                 .price(BigDecimal.valueOf(1000))
                 .build();
    }

    //get all the product
    @Test
    public void shouldGetAllProducts() throws Exception {
       //given
        ProductResponse productResponse = (ProductResponse) productService.getProducts();

        //when  //then

        mockMvc.perform(get("http://localhost:8080/api/v1/product/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("63f224e70448c6101c952b0f"))
                .andExpect(jsonPath("name").value("SamSun A13"))
                .andExpect(jsonPath("description").value("New SumSung model"))
                .andExpect(jsonPath("price").value(1000));


    }

    public ProductResponse getProductResponse(){
    return  ProductResponse
            .builder()
            .id("3f224e70448c6101c952b0f")
            .name("SamSun A13")
            .description("New SumSung model")
            .price(BigDecimal.valueOf(1000))
            .build();
    }

}