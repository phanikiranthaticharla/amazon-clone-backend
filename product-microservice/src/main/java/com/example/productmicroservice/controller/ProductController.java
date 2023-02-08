package com.example.productmicroservice.controller;

import com.example.productmicroservice.dto.ProductRequestDto;
import com.example.productmicroservice.dto.ProductResponseDto;
import com.example.productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/getAll")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search/{productId}")
    public ProductResponseDto getProductById(@PathVariable UUID productId) {
        return productService.getProductById(productId);
    }
}
