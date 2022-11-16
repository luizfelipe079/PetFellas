package com.petfellas.petfellas.controllers;

import com.petfellas.petfellas.model.dto.DonoDtoRequest;
import com.petfellas.petfellas.model.dto.DonoDtoResponse;
import com.petfellas.petfellas.services.DonoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/donos")
public class DonoController {

    private final DonoService donoService;

    public DonoController(DonoService donoService) {
        this.donoService = donoService;
    }

    @GetMapping
    public List<DonoDtoResponse> buscarDonos(){
        return donoService.buscarDonos();
    }

    @GetMapping(path = "/{id}")
    public DonoDtoResponse buscarDonoPorId(@PathVariable(value = "id") String id){
        return donoService.buscarDonoPorId(id);
    }

    @PostMapping
    public DonoDtoResponse salvarDono(@RequestBody DonoDtoRequest donoDtoRequest) {
        return donoService.salvarDono(donoDtoRequest);
    }

    @PutMapping(path = "/{id}")
    public DonoDtoResponse alterarDono(@PathVariable(value = "id") String id,
                                       @RequestBody DonoDtoRequest donoDtoRequest){
        return donoService.alterarDono(id, donoDtoRequest);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarDono(@PathVariable(value = "id") String id){
        donoService.deletarDono(id);
    }
}
