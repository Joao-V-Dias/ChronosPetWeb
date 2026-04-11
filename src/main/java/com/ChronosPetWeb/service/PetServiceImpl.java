package com.ChronosPetWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChronosPetWeb.model.Pet;
import com.ChronosPetWeb.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet){
        petRepository.save(pet);
    }

    @Override
    public void deletePetById(Long id){
        petRepository.deleteById(id);
    }

    @Override
    public Pet getPetById(Long id){
        return petRepository.findById(id).orElse(null);
    }
}
