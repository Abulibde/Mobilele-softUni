package com.example.demo.repository;

import com.example.demo.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    @EntityGraph(
            value = "brandsWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM BrandEntity b")
    List<BrandEntity> getAllBrands();
}
