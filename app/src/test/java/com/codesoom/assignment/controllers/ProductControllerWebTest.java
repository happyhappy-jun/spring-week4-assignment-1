package com.codesoom.assignment.controllers;

import com.codesoom.assignment.application.ProductService;
import com.codesoom.assignment.dto.ProductDto;
import com.codesoom.assignment.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ProductController MockMVC 테스트에서")
public class ProductControllerWebTest {
    private static final String PRODUCT_NAME = "상품1";
    private static final String PRODUCT_MAKER = "메이커1";
    private static final Integer PRODUCT_PRICE = 100000;
    private static final String PRODUCT_IMAGE_URL = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9941A1385B99240D2E";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductService productService;
    private ProductController productController;


    /**
     * 여러개의 Product 를 생성해 등록합니다.
     * @param createProuctSize 생성할 Product의 갯수
     */
    void createProducts(int createProuctSize) {
        for (int i = 0; i < createProuctSize; i++) {
            ProductDto productDto = new ProductDto
                    .Builder(PRODUCT_PRICE, PRODUCT_NAME)
                    .maker(PRODUCT_MAKER)
                    .imageUrl(PRODUCT_IMAGE_URL)
                    .build();
            productService.createProduct(productDto);
        }
    }

    /**
     * 하나의 Product 를 생성해 등록합니다.
     * @return 생성한 Product를 리턴
     */
    private Product createProduct() {
        ProductDto productDto = new ProductDto
                .Builder(PRODUCT_PRICE, PRODUCT_NAME)
                .maker(PRODUCT_MAKER)
                .imageUrl(PRODUCT_IMAGE_URL)
                .build();
        return productService.createProduct(productDto);
    }

    @BeforeEach
    void setUp() {
        productController = new ProductController(productService);
        productService.deleteAll();

        mockMvc = MockMvcBuilders
                .standaloneSetup(productController)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysExpect(content().contentType(APPLICATION_JSON))
                .build();
    }

    @Nested
    @DisplayName("GET - /products")
    class Describe_of_GET {

    }
}
