package br.com.thymeleaf.spring.repository;

import br.com.thymeleaf.spring.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

    //List<Instituicao> findByNomeContainingOrderByNomeAsc(String nome);

    @Query(value = "select * from instituicao i where upper(remover_acentos(i.nome)) like" +
            " concat('%', upper(remover_acentos(:nome)), '%') order by nome", nativeQuery = true)
    List<Instituicao> findByNome(@Param("nome") String nome);
}
