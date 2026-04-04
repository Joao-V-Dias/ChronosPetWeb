package com.ChronosPetWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.ChronosPetWeb.service.PetService;

import org.springframework.ui.Model;

public class PetController {
    
    @Autowired
    private PetService petService;

    @GetMapping("/pet")
    public String index(Model model){
        model.addAttribute("petList", petService.getAllPets());
        return "pet/index";
    }
}
