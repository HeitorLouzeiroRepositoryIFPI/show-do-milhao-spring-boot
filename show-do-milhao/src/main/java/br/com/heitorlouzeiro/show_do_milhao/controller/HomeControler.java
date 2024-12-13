package br.com.heitorlouzeiro.show_do_milhao.controller;

import org.springframework.web.bind.annotation.*;

import br.com.heitorlouzeiro.show_do_milhao.models.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeControler {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "homePage/home";
    }
}
