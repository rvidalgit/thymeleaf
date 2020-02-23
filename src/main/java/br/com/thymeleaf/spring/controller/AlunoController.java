package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.model.Aluno;
import br.com.thymeleaf.spring.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/alunos"))
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/teste")
    public ResponseEntity<Aluno> create() {
        Aluno aluno = new Aluno();
        aluno.setNome("teste");
        aluno.setIdade(14);
        return ResponseEntity.ok(alunoService.create(aluno));
    }
}
