package com.bercalini.candidato.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CandidatoVagaInput {
    private UUID candidatoId;
    @NotNull
    private UUID vagaId;
}
