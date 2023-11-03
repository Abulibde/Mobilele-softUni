package com.example.demo.web;

import com.example.demo.model.dto.CreateOfferDTO;
import com.example.demo.model.enums.EngineEnum;
import com.example.demo.service.BrandService;
import com.example.demo.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.UUID;


@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {

        this.offerService = offerService;
        this.brandService = brandService;
    }



    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("createOfferDTO")){
            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        model.addAttribute("brands", brandService.getALlBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createOfferDTO",createOfferDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";

        }



        offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }


}
