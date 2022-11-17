package com.petfellas.petfellas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDtoResponse {

    private Long id;
    private String nome;
    private String tipoAnimal;
    private String porte;
    private String nomeDono;
}
