package com.example.demo.repository;

import com.example.demo.model.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<BrandEntity, Long> {
}
