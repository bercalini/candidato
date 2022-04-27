package com.bercalini.candidato.repository;

import com.bercalini.candidato.model.CandidatoVaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidatoVagaRepository extends JpaRepository<CandidatoVaga, UUID> {
}
