package com.bercalini.candidato.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoVaga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID candidatoVagaId;
    private UUID vagaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidatoId")
    private Candidato candidato;
}
