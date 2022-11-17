package com.petfellas.petfellas.bootstrap;

import com.petfellas.petfellas.model.Dono;
import com.petfellas.petfellas.model.Pet;
import com.petfellas.petfellas.repositories.DonoRepository;
import com.petfellas.petfellas.repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GerarDados implements CommandLineRunner {

    private final DonoRepository donoRepository;
    private final PetRepository petRepository;

    public GerarDados(DonoRepository donoRepository, PetRepository petRepository) {
        this.donoRepository = donoRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Dono dono = new Dono(null, "Luiz", "luiz@gmail.com", "81988888888", "Senha123", null);
        Dono dono1 = new Dono(null, "Denys", "denys@gmail.com", "81988888828", "Senha123", null);
        Dono dono2 = new Dono(null, "Jackson", "jackson@gmail.com", "81988888288", "Senha123", null);

        donoRepository.saveAll(List.of(dono, dono1, dono2));

        Pet pet = new Pet(null, "toto", "Cachorro", "Pequeno", dono);
        Pet pet1 = new Pet(null, "tata", "Cachorro", "Grande", dono1);
        Pet pet2 = new Pet(null, "tete", "Gato", "Grande", dono);
        Pet pet3 = new Pet(null, "tica", "Cachorro", "Médio", dono2);

        petRepository.saveAll(List.of(pet, pet1, pet2, pet3));
    }
}
