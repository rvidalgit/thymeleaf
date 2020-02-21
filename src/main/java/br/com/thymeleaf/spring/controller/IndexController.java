package br.com.thymeleaf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String teste(Model model) {
        model.addAttribute("msg", "Página Inicial");
        return "index";
    }
}
