package com.bercalini.candidato.service.impl;

import com.bercalini.candidato.assembler.CandidatoAssembler;
import com.bercalini.candidato.assembler.CandidatoVagaAssembler;
import com.bercalini.candidato.client.VagaClient;
import com.bercalini.candidato.desassembler.CandidatoVagaDesassembler;
import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.dto.CandidatoVagaDTO;
import com.bercalini.candidato.dto.VagaDTO;
import com.bercalini.candidato.input.CandidatoVagaInput;
import com.bercalini.candidato.model.Candidato;
import com.bercalini.candidato.model.CandidatoVaga;
import com.bercalini.candidato.repository.CandidatoVagaRepository;
import com.bercalini.candidato.service.CandidatoService;
import com.bercalini.candidato.service.CandidatoVagaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class CandidatoVagaServiceImpl implements CandidatoVagaService {

    @Autowired
    private CandidatoVagaRepository candidatoVagaRepository;
    @Autowired
    private CandidatoVagaDesassembler candidatoVagaDesassembler;
    @Autowired
    private CandidatoService candidatoService;
    @Autowired
    private CandidatoAssembler candidatoAssembler;
    @Autowired
    private VagaClient vagaClient;

    @Override
    public CandidatoVaga salvar(UUID candidatoId, CandidatoVagaInput candidatoVagaInput) {
        CandidatoDTO candidatoDTO = candidatoService.buscarPorId(candidatoId);
        Candidato candidato = candidatoAssembler.converterCandidatoDTOTOCandidato(candidatoDTO);
        CandidatoVaga candidatoVaga = CandidatoVaga.builder().vagaId(candidatoVagaInput.getVagaId()).candidato(candidato).build();
        candidatoVaga = candidatoVagaRepository.save(candidatoVaga);
        log.info("Candidato salvo na vaga com sucesso {}", candidatoVaga.getCandidatoVagaId());
        return candidatoVaga;
        // return candidatoVagaDesassembler.converterCandidatoVagaTOCandidatoVagaDTO(candidatoVaga);
    }

    @Override
    public Page<VagaDTO> listarVagaPorCandidatoId(UUID candidatoId, Pageable pageable) {
        return vagaClient.listarVagaPorCandidatoId(candidatoId, pageable);
    }
}
