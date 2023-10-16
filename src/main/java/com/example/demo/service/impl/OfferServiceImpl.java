package com.example.demo.service.impl;

import com.example.demo.model.dto.CreateOfferDTO;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
         //TODO create offer
        throw new UnsupportedOperationException("Comming soon");
    }
}
