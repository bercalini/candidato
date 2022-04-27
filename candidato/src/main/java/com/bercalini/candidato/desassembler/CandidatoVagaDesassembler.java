package com.bercalini.candidato.desassembler;

import com.bercalini.candidato.dto.CandidatoVagaDTO;
import com.bercalini.candidato.model.CandidatoVaga;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatoVagaDesassembler {

    @Autowired
    private ModelMapper modelMapper;

    public CandidatoVagaDTO converterCandidatoVagaTOCandidatoVagaDTO(CandidatoVaga candidatoVaga) {
        return modelMapper.map(candidatoVaga, CandidatoVagaDTO.class);
    }
}
