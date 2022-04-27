package com.bercalini.candidato.service.impl;

import com.bercalini.candidato.service.UtilService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilServiceImpl implements UtilService {


    @Override
    public String createUrlVaga(UUID candidatoId, Pageable pageable) {
        return "/vagas?candidatoId=" + candidatoId + "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() + "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
