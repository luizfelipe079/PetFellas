package com.petfellas.petfellas.repositories;

import com.petfellas.petfellas.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {



}
