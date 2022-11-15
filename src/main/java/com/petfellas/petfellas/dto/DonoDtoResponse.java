package com.petfellas.petfellas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DonoDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
