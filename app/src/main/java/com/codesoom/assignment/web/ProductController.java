package com.codesoom.assignment.web;

import com.codesoom.assignment.application.ProductService;
import com.codesoom.assignment.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createTask(productDto);
    }
}
