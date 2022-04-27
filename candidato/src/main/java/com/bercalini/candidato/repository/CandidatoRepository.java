package com.bercalini.candidato.repository;

import com.bercalini.candidato.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CandidatoRepository extends JpaRepository<Candidato, UUID>, JpaSpecificationExecutor<Candidato> {
}
