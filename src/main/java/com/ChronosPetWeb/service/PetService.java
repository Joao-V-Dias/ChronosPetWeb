package com.ChronosPetWeb.service;

import java.util.List;

import com.ChronosPetWeb.model.Pet;

public interface PetService {
    List<Pet> getAllPets();
    void savePet(Pet pet);
    void deletePetById(Long id);
    Pet getPetById(Long id);
}
