package com.example.demo.service.impl;

import com.example.demo.model.dto.BrandDTO;
import com.example.demo.model.dto.ModelDTO;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository){
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandDTO> getALlBrands() {

        //todo: better implementation

       /* Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model : modelRepository.findAll()){
             if (!brands.containsKey(model.getBrand().getName())){
                 brands.put(model.getBrand().getName(),
                         new BrandDTO(model.getBrand().getName(),
                         new ArrayList<>()));
             }

             brands.get(model.getBrand().getName()).models().add(
                     new ModelDTO(model.getId(), model.getName()));
        }


        return brands.values().stream().toList();*/
        return brandRepository.findAll().stream()
                .map(brand -> new BrandDTO(
                brand.getName(),
                brand.getModels().stream()
                        .map(model -> new ModelDTO(model.getId(),model.getName()))
                        .sorted(Comparator.comparing(ModelDTO::brand))
                        .collect(Collectors.toList())
        ))
                .sorted(Comparator.comparing(BrandDTO::brand))
                .collect(Collectors.toList());
    }
}
