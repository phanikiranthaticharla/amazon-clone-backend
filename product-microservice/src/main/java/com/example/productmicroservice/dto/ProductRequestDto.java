package com.example.productmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private UUID productId;
    private String name;
    private double price;
    private double rating;
    private String imageURL;
}
