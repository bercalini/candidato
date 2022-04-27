package com.bercalini.candidato.assembler;

import com.bercalini.candidato.dto.CandidatoVagaDTO;
import com.bercalini.candidato.model.CandidatoVaga;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatoVagaAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CandidatoVaga converterCandidatoVagaTOCandidatoVagaDTO(CandidatoVagaDTO candidatoVagaDTO) {
        return modelMapper.map(candidatoVagaDTO, CandidatoVaga.class);
    }
}
