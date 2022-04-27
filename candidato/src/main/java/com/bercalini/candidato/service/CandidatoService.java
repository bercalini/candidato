package com.bercalini.candidato.service;

import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.input.CandidatoInput;
import com.bercalini.candidato.model.Candidato;
import com.bercalini.candidato.specification.CandidatoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public interface CandidatoService {
    CandidatoDTO salvar(CandidatoInput candidatoInput);
    CandidatoDTO buscarPorId(UUID candidatoId);
    Page<CandidatoDTO> listar(Specification<Candidato> candidatoSpec, Pageable pageable);
    CandidatoDTO atualizar(UUID candidatoId, CandidatoInput candidatoInput);
}
