package com.bercalini.candidato.service.impl;

import com.bercalini.candidato.assembler.CandidatoAssembler;
import com.bercalini.candidato.desassembler.CandidatoDesassembler;
import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.exception.CandidatoNaoEncontradoException;
import com.bercalini.candidato.input.CandidatoInput;
import com.bercalini.candidato.model.Candidato;
import com.bercalini.candidato.repository.CandidatoRepository;
import com.bercalini.candidato.service.CandidatoService;
import com.bercalini.candidato.specification.CandidatoSpecification;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private CandidatoAssembler candidatoAssembler;
    @Autowired
    private CandidatoDesassembler candidatoDesassembler;

    @Override
    public CandidatoDTO salvar(CandidatoInput candidatoInput) {
        Candidato candidatoSalvo = candidatoRepository.save(candidatoAssembler.converterCandidatoInputTOCandidato(candidatoInput));
        log.info("POST /candidatos, candidato salvo com sucesso {} ", candidatoSalvo.getCandidatoId());
        return candidatoDesassembler.converterCandidatoTOCandidatoDTO(candidatoSalvo);
    }

    @Override
    public CandidatoDTO buscarPorId(UUID candidatoId) {
        return candidatoDesassembler.converterCandidatoTOCandidatoDTO(verificarId(candidatoId));
    }

    @Override
    public Page<CandidatoDTO> listar(Specification<Candidato> candidatoSpec, Pageable pageable) {
        Page<Candidato> candidatoPages = candidatoRepository.findAll(candidatoSpec, pageable);
        List<CandidatoDTO> candidatoDTOS = candidatoDesassembler.converterListCandidatoTOListCandidatoDTO(candidatoPages.getContent());
        return new PageImpl<>(candidatoDTOS, pageable, candidatoPages.getTotalElements());
    }

    @Override
    @Transactional
    public CandidatoDTO atualizar(UUID candidatoId, CandidatoInput candidatoInput) {
        Candidato candidato = verificarId(candidatoId);
        BeanUtils.copyProperties(candidatoInput, candidato, "id", "dataCadastro");
        return candidatoDesassembler.converterCandidatoTOCandidatoDTO(candidato);
    }

    private Candidato verificarId(UUID candidatoId) {
        return candidatoRepository.findById(candidatoId).orElseThrow(() -> new CandidatoNaoEncontradoException("Candidato com o id " + candidatoId + " não encontrado"));
    }
}
