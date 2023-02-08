package com.example.productmicroservice.repository;

import com.example.productmicroservice.dto.ProductResponseDto;
import com.example.productmicroservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, BigInteger> {
    public Optional<Product> findByproductId(UUID productId);
}
