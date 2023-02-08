package com.example.productmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private BigInteger id;
    private UUID productId;
    private String name;
    private double price;
    private double rating;
    private String imageURL;
}
