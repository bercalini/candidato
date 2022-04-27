package com.bercalini.candidato.desassembler;

import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.input.CandidatoInput;
import com.bercalini.candidato.model.Candidato;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidatoDesassembler {

    @Autowired
    private ModelMapper modelMapper;

    public CandidatoDTO converterCandidatoTOCandidatoDTO(Candidato candidato) {
        return modelMapper.map(candidato, CandidatoDTO.class);
    }

    public List<CandidatoDTO> converterListCandidatoTOListCandidatoDTO(List<Candidato> candidatos) {
        return candidatos.stream().map(c -> converterCandidatoTOCandidatoDTO(c)).collect(Collectors.toList());
    }

}
