package com.petfellas.petfellas.model.dto;

import com.petfellas.petfellas.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonoDtoRequest {

    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private List<Pet> pets;
}
