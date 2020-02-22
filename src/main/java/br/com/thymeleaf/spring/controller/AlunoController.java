package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.service.AlunoService;
import org.springframework.stereotype.Controller;

@Controller("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


}
