package com.example.demo.model.dto;

import com.example.demo.model.entity.ModelEntity;

import java.util.List;

public record BrandDTO (String brand, List<ModelEntity> models) {
}
