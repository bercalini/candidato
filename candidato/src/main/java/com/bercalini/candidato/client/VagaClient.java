package com.bercalini.candidato.client;

import com.bercalini.candidato.dto.ResponsePageDTO;
import com.bercalini.candidato.dto.VagaDTO;
import com.bercalini.candidato.service.UtilService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Log4j2
public class VagaClient {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${bercalini.api.url.vaga}")
    private String REQUEST_URL;
    @Autowired
    private UtilService utilService;

    public Page<VagaDTO> listarVagaPorCandidatoId(UUID candidatoId, Pageable pageable) {
        String url = REQUEST_URL + utilService.createUrlVaga(candidatoId, pageable);
        log.info("URL {}", url);
        ParameterizedTypeReference<ResponsePageDTO<VagaDTO>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};
        ResponseEntity<ResponsePageDTO<VagaDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, parameterizedTypeReference);
        return new PageImpl<>(responseEntity.getBody().getContent());
    }

}
