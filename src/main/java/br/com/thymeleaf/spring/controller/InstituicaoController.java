package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.InstituicaoService;
import br.com.thymeleaf.spring.model.Instituicao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("instituicao/index");
        List<Instituicao> listaDeInstituicoes = this.instituicaoService.findAll();
        modelAndView.addObject("instituicoes", listaDeInstituicoes);
        return modelAndView;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir(){
        ModelAndView modelAndView = new ModelAndView("instituicao/inserir");
        modelAndView.addObject("instituicao", new Instituicao());
        return modelAndView;
    }


}
