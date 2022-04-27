package com.bercalini.candidato.dto;

import com.bercalini.candidato.enumm.Seriornidade;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class VagaDTO {
    private UUID vagaId;
    private String nome;
    private String descricao;
    private Seriornidade seriornidade;
    private BigDecimal salario;
    private UUID candidatoId;
}
