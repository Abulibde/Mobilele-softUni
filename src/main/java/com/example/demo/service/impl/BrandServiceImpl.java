package com.example.demo.service.impl;

import com.example.demo.model.dto.BrandDTO;
import com.example.demo.model.dto.ModelDTO;
import com.example.demo.model.entity.BrandEntity;
import com.example.demo.model.entity.ModelEntity;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }


    @Override
    public List<BrandDTO> getALlBrands() {

        //todo: better implementation

        Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model : modelRepository.findAll()){
             if (!brands.containsKey(model.getBrand().getBrand())){
                 brands.put(model.getBrand().getBrand(),
                         new BrandDTO(model.getBrand().getBrand(),
                         new ArrayList<>()));
             }

             brands.get(model.getBrand().getBrand()).models().add(
                     new ModelDTO(model.getId(), model.getName()));
        }


        return brands.values().stream().toList();
    }
}
