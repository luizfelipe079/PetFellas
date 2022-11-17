package com.petfellas.petfellas.services;

import com.petfellas.petfellas.exceptions.ResourceNotFoundException;
import com.petfellas.petfellas.model.dto.DonoDtoRequest;
import com.petfellas.petfellas.model.dto.DonoDtoResponse;
import com.petfellas.petfellas.model.Dono;
import com.petfellas.petfellas.repositories.DonoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonoService {

    private final DonoRepository donoRepository;

    public DonoService(DonoRepository donoRepository) {
        this.donoRepository = donoRepository;
    }

    public DonoDtoResponse salvarDono(DonoDtoRequest donoDtoRequest) {
        Dono dono = new Dono(null, donoDtoRequest.getNome(), donoDtoRequest.getEmail(), donoDtoRequest.getTelefone(), donoDtoRequest.getSenha(), null);

        Dono novoDono = donoRepository.save(dono);

        return new DonoDtoResponse(novoDono.getId(), novoDono.getNome(), novoDono.getEmail(), novoDono.getTelefone(), novoDono.getPets());
    }

    public List<DonoDtoResponse> buscarDonos() {

        List<Dono> donos = donoRepository.findAll();

        List<DonoDtoResponse> donosResponse = new ArrayList<>();

        for (Dono dono : donos) {
            donosResponse.add(new DonoDtoResponse(dono.getId(), dono.getNome(), dono.getEmail(), dono.getTelefone(), dono.getPets()));
        }

        return donosResponse;
    }

    public DonoDtoResponse buscarDonoPorId(String id) {

        Dono dono = donoRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Dono não encontrado"));

        return new DonoDtoResponse(dono.getId(), dono.getNome(), dono.getEmail(), dono.getTelefone(), dono.getPets());
    }

    public DonoDtoResponse alterarDono(String id, DonoDtoRequest donoDtoRequest) {

        Dono dono = donoRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("Dono não encontrado"));

        Dono donoAtualizado = this.atualizarParamatrosDono(dono, donoDtoRequest);

        Dono donoSave = donoRepository.save(donoAtualizado);

        return new DonoDtoResponse(donoSave.getId(), donoSave.getNome(), donoSave.getEmail(), donoSave.getTelefone(), donoSave.getPets());
    }

    public void deletarDono(String id) {
        this.buscarDonoPorId(id);

        donoRepository.deleteById(Long.valueOf(id));
    }

    private Dono atualizarParamatrosDono(Dono dono, DonoDtoRequest donoDtoRequest){
        if (donoDtoRequest.getNome() != null){
            dono.setNome(donoDtoRequest.getNome());
        }

        if (donoDtoRequest.getEmail() != null){
            dono.setEmail(donoDtoRequest.getEmail());
        }

        if (donoDtoRequest.getTelefone() != null){
            dono.setTelefone(donoDtoRequest.getTelefone());
        }

        if (donoDtoRequest.getSenha() != null) {
            dono.setSenha(donoDtoRequest.getSenha());
        }
//
//        if(!donoDtoRequest.getIdPets().isEmpty()){
//
//        }

        return dono;
    }
}
