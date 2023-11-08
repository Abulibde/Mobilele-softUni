package com.example.demo.service.impl;

import com.example.demo.model.dto.CreateOfferDTO;
import com.example.demo.model.entity.ModelEntity;
import com.example.demo.model.entity.OfferEntity;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository){
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = map(createOfferDTO);

        ModelEntity modelEntity= modelRepository.findById(createOfferDTO.getModelId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Model with id: " + createOfferDTO.getModelId() + " not found!"));

        newOffer.setModel(modelEntity);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    private OfferEntity map(CreateOfferDTO createOfferDTO){

        OfferEntity newOffer = new OfferEntity();

        newOffer.setUuid(UUID.randomUUID());
        newOffer.setDescription(createOfferDTO.getDescription());
        newOffer.setEngine(createOfferDTO.getEngine());
        newOffer.setTransmission(createOfferDTO.getTransmission());
        newOffer.setImgUrl(createOfferDTO.getImageUrl());
        newOffer.setMileage(createOfferDTO.getMileage());
        newOffer.setPrice(BigDecimal.valueOf(createOfferDTO.getPrice()));
        newOffer.setYear(createOfferDTO.getYear());

        return newOffer;

    }

}
