package com.bercalini.candidato.service;

import com.bercalini.candidato.dto.CandidatoVagaDTO;
import com.bercalini.candidato.dto.VagaDTO;
import com.bercalini.candidato.input.CandidatoVagaInput;
import com.bercalini.candidato.model.CandidatoVaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CandidatoVagaService {
    CandidatoVaga salvar(UUID candidatoId, CandidatoVagaInput candidatoVagaInput);
    Page<VagaDTO> listarVagaPorCandidatoId(UUID candidatoId, Pageable pageable);
}
