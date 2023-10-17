package com.example.demo.model.dto;

import com.example.demo.model.enums.EngineEnum;
import com.example.demo.model.enums.Transmission;

public record CreateOfferDTO(
        String description,
        Long modelId,
        EngineEnum engine,
        Transmission transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year
) {
}
