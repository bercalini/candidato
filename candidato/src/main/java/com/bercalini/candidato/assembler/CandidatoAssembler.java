package com.bercalini.candidato.assembler;

import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.input.CandidatoInput;
import com.bercalini.candidato.model.Candidato;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public Candidato converterCandidatoInputTOCandidato(CandidatoInput candidatoInput) {
        return modelMapper.map(candidatoInput, Candidato.class);
    }

    public Candidato converterCandidatoDTOTOCandidato(CandidatoDTO candidatoDTO) {
        return modelMapper.map(candidatoDTO, Candidato.class);
    }
}
