package com.example.demo.web;

import com.example.demo.model.dto.CreateOfferDTO;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.UUID;


@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String all() {
        return "offers";
    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(CreateOfferDTO createOfferDTO) {

        offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }


}
