package com.bercalini.candidato.model;

import com.bercalini.candidato.enumm.Seriornidade;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tbl_candidato")
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID candidatoId;
    private String primeiroNome;
    private String nomeCompleto;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Seriornidade seriornidade;

    @Embedded
    private DadosPessoais dadosPessoais;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "candidato")
    private List<CandidatoVaga> candidatoVagas;
}
