package com.example.demo.model.dto;


import java.util.List;

public record BrandDTO (String brand, List<ModelDTO> models) {
}
