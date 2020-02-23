package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.model.Aluno;
import br.com.thymeleaf.spring.model.Instituicao;
import br.com.thymeleaf.spring.service.AlunoService;
import br.com.thymeleaf.spring.service.InstituicaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(("/alunos"))
public class AlunoController {

    private AlunoService alunoService;
    private InstituicaoService instituicaoService;

    public AlunoController(AlunoService alunoService, InstituicaoService instituicaoService) {
        this.alunoService = alunoService;
        this.instituicaoService = instituicaoService;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("aluno/index");
        List<Aluno> alunos = this.alunoService.findAll();
        model.addObject("alunos", alunos);
        return model;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView model = new ModelAndView("aluno/inserir");
        Aluno aluno = new Aluno();
        aluno.setInstituicao(new Instituicao());
        model.addObject("aluno", aluno);
        model.addObject("instituicoes", this.instituicaoService.findAll());
        return model;
    }

    @PostMapping("/inserir")
    public String inserir(Aluno aluno) {
        this.alunoService.save(aluno);
        return "redirect:/alunos/index";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") String idUsuario) {
        UUID uuid = UUID.fromString(idUsuario);
        this.alunoService.delete(uuid);
        return "redirect:/alunos/index";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") String idUsuario) {
        UUID uuid = UUID.fromString(idUsuario);
        Aluno aluno = null;
        Optional<Aluno> result = this.alunoService.info(uuid);
        if (result.isPresent()) {
            aluno = result.get();
        }

        ModelAndView model = new ModelAndView("aluno/editar");
        model.addObject("aluno", aluno);
        model.addObject("instituicoes", this.instituicaoService.findAll());
        return model;
    }

    @PostMapping("/editar")
    public String editar(Aluno aluno) {
        this.alunoService.save(aluno);
        return "redirect:/alunos/index";
    }
}
