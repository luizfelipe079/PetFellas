package com.petfellas.petfellas.services;






import com.petfellas.petfellas.exceptions.ResourceNotFoundException;
import com.petfellas.petfellas.model.Dono;
import com.petfellas.petfellas.model.Pet;
import com.petfellas.petfellas.model.dto.PetDtoRequest;
import com.petfellas.petfellas.model.dto.PetDtoResponse;
import com.petfellas.petfellas.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public PetDtoResponse salvarPet(PetDtoRequest petDtoRequest){

        Dono dono = new Dono();
        dono.setId(Long.valueOf(petDtoRequest.getIdDono()));

        Pet pet = new Pet(null, petDtoRequest.getNome(), petDtoRequest.getTipoAnimal(), petDtoRequest.getPorte(), dono);

        Pet novoPet = petRepository.save(pet);

        return new PetDtoResponse(novoPet.getId(), novoPet.getNome(), novoPet.getTipoAnimal(), novoPet.getPorte(), novoPet.getDono().getNome());


    }

    public List<PetDtoResponse> buscarPets(){

        List<Pet> pets = petRepository.findAll();

        List<PetDtoResponse> petResponse = new ArrayList<>();

        for (Pet pet : pets) {
            petResponse.add(new PetDtoResponse(pet.getId(), pet.getNome(), pet.getTipoAnimal(), pet.getPorte(), pet.getDono().getNome()));
        }

        return petResponse;
    }

    public PetDtoResponse buscarPetPorId(Long id){

        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " +id));

        return new PetDtoResponse(pet.getId(), pet.getNome(), pet.getTipoAnimal(), pet.getPorte(), pet.getDono().getNome());

    }

    public PetDtoResponse alterarPet(Long id, PetDtoRequest petDtoRequest){

        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " +id));

        Pet petAtualizado = this.atualizarParamatrosPet(pet, petDtoRequest);

        Pet petSalvo = petRepository.save(petAtualizado);

        return new PetDtoResponse(petSalvo.getId(), petSalvo.getNome(), petSalvo.getTipoAnimal(), petSalvo.getPorte(), petSalvo.getDono().getNome());

    }

    public void deletarPet(Long id) {
        this.buscarPetPorId(id);

        petRepository.deleteById(id);
    }



    private Pet atualizarParamatrosPet(Pet pet, PetDtoRequest petDtoRequest){
        if (petDtoRequest.getNome() != null){
            pet.setNome(petDtoRequest.getNome());
        }

        if (petDtoRequest.getTipoAnimal() != null){
            pet.setTipoAnimal(petDtoRequest.getTipoAnimal());
        }

        if (petDtoRequest.getPorte() != null){
            pet.setPorte(petDtoRequest.getPorte());
        }

        return pet;
    }

}
