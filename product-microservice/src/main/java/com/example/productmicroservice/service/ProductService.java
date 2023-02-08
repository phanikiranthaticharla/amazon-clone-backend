package com.example.productmicroservice.service;

import com.example.productmicroservice.dto.ProductRequestDto;
import com.example.productmicroservice.dto.ProductResponseDto;
import com.example.productmicroservice.entity.Product;
import com.example.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = mapProductRequestToProduct(productRequestDto);
        productRepository.save(product);
        return mapProductToProductResponseDto(product);
    }

    public Product mapProductRequestToProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setProductId(UUID.randomUUID());
        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());
        product.setRating(productRequestDto.getRating());
        product.setImageURL(productRequestDto.getImageURL());
        return product;
    }

    public ProductResponseDto mapProductToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setRating(product.getRating());
        productResponseDto.setImageURL(product.getImageURL());
        return productResponseDto;
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(this::mapProductToProductResponseDto)
                .collect(Collectors.toList());
    }


    public ProductResponseDto getProductById(UUID productId) {
        Optional<Product> product = productRepository.findByproductId(productId);
        return product.isPresent() ? mapProductToProductResponseDto(product.stream().findFirst().get()) : null;
    }
}
