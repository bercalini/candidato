package com.bercalini.candidato.input;

import com.bercalini.candidato.enumm.Seriornidade;
import com.bercalini.candidato.model.DadosPessoais;
import lombok.Data;


@Data
public class CandidatoInput {
    private String primeiroNome;
    private String nomeCompleto;
    private String cpf;
    private Seriornidade seriornidade;
    private DadosPessoaisInput dadosPessoais;
}
