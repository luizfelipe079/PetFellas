package com.petfellas.petfellas.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDtoRequest {

    private String nome;
    private String tipoAnimal;
    private String porte;
}
