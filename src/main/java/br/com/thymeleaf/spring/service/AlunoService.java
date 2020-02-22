package br.com.thymeleaf.spring.service;

import br.com.thymeleaf.spring.model.Aluno;
import br.com.thymeleaf.spring.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno create(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }
}
