package com.ChronosPetWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChronosPetWeb.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
