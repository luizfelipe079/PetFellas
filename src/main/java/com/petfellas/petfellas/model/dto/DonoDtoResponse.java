package com.petfellas.petfellas.model.dto;

import com.petfellas.petfellas.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DonoDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<Pet> pets;

}
