package br.com.thymeleaf.spring.repository;

import br.com.thymeleaf.spring.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {


    List<Instituicao> findByNomeContainingOrderByNomeAsc(String nome);
}
