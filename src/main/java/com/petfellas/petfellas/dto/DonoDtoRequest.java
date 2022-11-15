package com.petfellas.petfellas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonoDtoRequest {

    private String nome;
    private String email;
    private String telefone;
    private String senha;
}
