package com.bercalini.candidato.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais {
    private String celular;
    private String cidade;
    private String estado;
}
