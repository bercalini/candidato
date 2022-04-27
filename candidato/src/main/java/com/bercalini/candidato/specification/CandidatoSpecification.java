package com.bercalini.candidato.specification;

import com.bercalini.candidato.model.Candidato;
import com.bercalini.candidato.model.CandidatoVaga;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.util.UUID;

public class CandidatoSpecification {

    @And({
            @Spec(path = "cpf", spec = Equal.class),
            @Spec(path = "nomeCompleto", spec = Like.class)
    })
    public interface CandidatoSpec extends Specification<Candidato> {};

    public static Specification<Candidato> listarCandidatoPorVagaId(UUID vagaId) {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true);
            Join<Candidato, CandidatoVaga> candidatoVagas = root.join("candidatoVagas");
            return criteriaBuilder.equal(candidatoVagas.get("vagaId"), vagaId);
        };
    }
}
