package com.ChronosPetWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ChronosPetWeb.model.Pet;
import com.ChronosPetWeb.service.PetService;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/pet")
    public String index(Model model){
        model.addAttribute("petList", petService.getAllPets());
        return "pet/index";
    }

    @GetMapping("/pet/create")
    public String showCreateForm(Model model){
        model.addAttribute("pet", new Pet());
        return "pet/create";
    }

    @PostMapping("/pet/create")
    public String createPet(Pet pet){
        petService.savePet(pet);
        return "redirect:/pet";
    }

    @GetMapping("/pet/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Pet pet = petService.getPetById(id);
        if (pet == null) {
            return "redirect:/pet";
        }
        model.addAttribute("pet", pet);
        return "pet/edit";
    }

    @PostMapping("/pet/edit/{id}")
    public String updatePet(@PathVariable Long id, Pet pet){
        pet.setId(id);
        petService.savePet(pet);
        return "redirect:/pet";
    }

    @PostMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable Long id){
        petService.deletePetById(id);
        return "redirect:/pet";
    }
}
