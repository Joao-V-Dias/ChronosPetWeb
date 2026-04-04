package com.ChronosPetWeb.service;

import java.util.List;

import com.ChronosPetWeb.model.Pet;

public interface PetService {
    List<Pet> getAllPets();
    void savePet(Pet pet);
    // Pet getPetById(long id);
    // void deletePetById();
}
