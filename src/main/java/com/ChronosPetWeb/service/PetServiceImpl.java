package com.ChronosPetWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.ChronosPetWeb.model.Pet;
import com.ChronosPetWeb.repository.PetRepository;

public class PetServiceImpl implements PetService{
    
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public void savePet(Pet pet){
        petRepository.save(pet);
    }
}
