package com.example.demo.repository;

import com.example.demo.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {


}
