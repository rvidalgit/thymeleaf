package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.InstituicaoService;
import br.com.thymeleaf.spring.model.Instituicao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    /**
     * Método resposável por retornar a página de listagem.
     *
     * @return ModelAndView
     * */
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("instituicao/index");
        List<Instituicao> listaDeInstituicoes = this.instituicaoService.findAll();
        modelAndView.addObject("instituicoes", listaDeInstituicoes);
        return modelAndView;
    }

    /**
     * Método resposável por retornar a página de cadastro.
     *
     * @return ModelAndView
     * */
    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView modelAndView = new ModelAndView("instituicao/inserir");
        modelAndView.addObject("instituicao", new Instituicao());
        return modelAndView;
    }

    /**
     * Método resposável por retornar a página de listagem.
     *
     * @param instituicao Instituicao
     * @return "redirect:/instituicoes/index"
     * */
    @PostMapping("/inserir")
    public String inserir(Instituicao instituicao) {
        this.instituicaoService.save(instituicao);
        return "redirect:/instituicoes/index";
    }

}
