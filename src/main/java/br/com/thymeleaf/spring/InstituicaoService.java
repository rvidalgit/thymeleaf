package br.com.thymeleaf.spring;

import br.com.thymeleaf.spring.model.Instituicao;
import br.com.thymeleaf.spring.repository.InstituicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoService(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public List<Instituicao> findAll() {
        return this.instituicaoRepository.findAll();
    }
}
