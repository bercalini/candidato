package com.bercalini.candidato.controller;

import com.bercalini.candidato.dto.CandidatoVagaDTO;
import com.bercalini.candidato.dto.VagaDTO;
import com.bercalini.candidato.input.CandidatoVagaInput;
import com.bercalini.candidato.model.CandidatoVaga;
import com.bercalini.candidato.service.CandidatoVagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CandidatoVagaController {

    @Autowired
    private CandidatoVagaService candidatoVagaService;

    @PostMapping("/candidato/{candidatoId}/vaga")
    @ResponseStatus(HttpStatus.CREATED)
    public CandidatoVaga salvar(@PathVariable UUID candidatoId, @RequestBody CandidatoVagaInput candidatoVagaInput) {
        return candidatoVagaService.salvar(candidatoId, candidatoVagaInput);
    }

    @GetMapping("/candidato/{candidatoId}/vagas")
    public Page<VagaDTO> listarVagaPorCandidatoId(@PathVariable UUID candidatoId,
                                                  @PageableDefault(page = 0, size = 10, sort = "vagaId", direction = Sort.Direction.ASC)Pageable pageable) {
        return candidatoVagaService.listarVagaPorCandidatoId(candidatoId, pageable);
    }
}
