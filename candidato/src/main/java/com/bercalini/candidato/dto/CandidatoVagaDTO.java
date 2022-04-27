package com.bercalini.candidato.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CandidatoVagaDTO {
    private UUID candidatoVagaId;
    private UUID vagaId;
    private CandidatoDTO candidato;
}
