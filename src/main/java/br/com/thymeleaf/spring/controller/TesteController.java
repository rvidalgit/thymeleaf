package br.com.thymeleaf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @GetMapping("/")
    public String teste(Model model){
        model.addAttribute("teste", "Mensagem de teste!!");
        return "index";
    }
}
