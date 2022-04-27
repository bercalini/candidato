package com.bercalini.candidato.controller;

import com.bercalini.candidato.dto.CandidatoDTO;
import com.bercalini.candidato.input.CandidatoInput;
import com.bercalini.candidato.service.CandidatoService;
import com.bercalini.candidato.specification.CandidatoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CandidatoDTO salvar(@RequestBody @Valid CandidatoInput candidatoInput) {
        return candidatoService.salvar(candidatoInput);
    }

    @GetMapping("/{candidatoId}")
    public CandidatoDTO buscarPorId(@PathVariable UUID candidatoId) {
        return candidatoService.buscarPorId(candidatoId);
    }

    @GetMapping
    public Page<CandidatoDTO> listar(CandidatoSpecification.CandidatoSpec candidatoSpec,
                                     @PageableDefault(page = 0, size = 10, sort = "candidatoId", direction = Sort.Direction.ASC)Pageable pageable,
                                     @RequestParam(required = false)UUID vagaId) {
        if (vagaId == null) {
            return candidatoService.listar(candidatoSpec, pageable);
        }
        return  candidatoService.listar(CandidatoSpecification.listarCandidatoPorVagaId(vagaId).and(candidatoSpec), pageable);
    }

    @PutMapping("/{candidatoId}")
    public CandidatoDTO atualizar(@PathVariable UUID candidatoId, @RequestBody @Valid CandidatoInput candidatoInput) {
        return candidatoService.atualizar(candidatoId, candidatoInput);
    }
}
