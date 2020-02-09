package br.com.thymeleaf.spring.controller;

import br.com.thymeleaf.spring.InstituicaoService;
import br.com.thymeleaf.spring.model.Instituicao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
     */
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
     */
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
     */
    @PostMapping("/inserir")
    public String inserir(Instituicao instituicao) {
        this.instituicaoService.save(instituicao);
        return "redirect:/instituicoes/index";
    }

    @GetMapping("/editar/{idInstituicao}")
    public ModelAndView editar(@PathVariable("idInstituicao") Long idInstituicao) {
        Instituicao instituicao = null;
        Optional<Instituicao> result = this.instituicaoService.info(idInstituicao);
        if(result.isPresent()){
            instituicao = result.get();
        }
        ModelAndView model = new ModelAndView("/instituicao/editar");
        model.addObject("instituicao", instituicao);
        return model;
    }

    @PostMapping("/editar")
    public String editar(Instituicao instituicao){
        this.instituicaoService.save(instituicao);
        return "redirect:/instituicoes/index";
    }

    @GetMapping("/excluir/{id}")
    public String apagar(@PathVariable("id") Long id){
        this.instituicaoService.delete(id);
        return "redirect:/instituicoes/index";
    }
}
