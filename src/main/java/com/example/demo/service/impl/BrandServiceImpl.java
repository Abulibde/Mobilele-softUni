package com.example.demo.service.impl;

import com.example.demo.model.dto.BrandDTO;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }


    @Override
    public List<BrandDTO> getALlBrands() {

        return null;
    }
}
