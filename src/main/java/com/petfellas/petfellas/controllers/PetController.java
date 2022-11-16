package com.petfellas.petfellas.controllers;

import com.petfellas.petfellas.model.dto.DonoDtoRequest;
import com.petfellas.petfellas.model.dto.DonoDtoResponse;
import com.petfellas.petfellas.model.dto.PetDtoRequest;
import com.petfellas.petfellas.model.dto.PetDtoResponse;
import com.petfellas.petfellas.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping
    public List<PetDtoResponse> buscarPets(){
        return petService.buscarPets();
    }

    @GetMapping(path = "/{id}")
    public PetDtoResponse buscarPetPorId(@PathVariable(value = "id") Long id){
        return petService.buscarPetPorId(id);
    }

    @PostMapping
    public PetDtoResponse salvarPet(@RequestBody PetDtoRequest petDtoRequest) {
        return petService.salvarPet(petDtoRequest);
    }

    @PutMapping(path = "/{id}")
    public PetDtoResponse alterarPet(@PathVariable(value = "id") Long id,
                                       @RequestBody PetDtoRequest petDtoRequest){
        return petService.alterarPet(id, petDtoRequest);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarPet(@PathVariable(value = "id") Long id){
        petService.deletarPet(id);
    }


}
