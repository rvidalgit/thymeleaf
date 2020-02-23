package br.com.thymeleaf.spring.service;

import br.com.thymeleaf.spring.model.Aluno;
import br.com.thymeleaf.spring.repository.AlunoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno save(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return this.alunoRepository.findAll(sort);
    }

    public void delete(UUID uuid) {
        this.alunoRepository.deleteById(uuid);
    }

    public Optional<Aluno> info(UUID uuid) {
        return this.alunoRepository.findById(uuid);
    }
}
