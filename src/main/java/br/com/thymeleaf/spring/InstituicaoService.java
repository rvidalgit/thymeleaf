package br.com.thymeleaf.spring;

import br.com.thymeleaf.spring.model.Instituicao;
import br.com.thymeleaf.spring.repository.InstituicaoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoService(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    /**
     * Lista todas as instituições ordenadas pela nome.
     *
     * @return List<Instituicao>
     */
    public List<Instituicao> findAll() {
        return this.instituicaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    /**
     * Salva uma instituição.
     *
     * @param instituicao Instituicao
     * @return instituicao Instituicao
     */
    public Instituicao save(Instituicao instituicao) {
        return this.instituicaoRepository.save(instituicao);
    }
}
