package com.bercalini.candidato.service;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilService {
    String createUrlVaga(UUID candidatoId, Pageable pageable);
}
