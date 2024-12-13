package br.com.heitorlouzeiro.show_do_milhao.controller;

import org.springframework.web.bind.annotation.*;

import br.com.heitorlouzeiro.show_do_milhao.models.Usuario;
import br.com.heitorlouzeiro.show_do_milhao.repositorio.Repositorio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeControler {

    private Repositorio repositorio;

    @GetMapping("/")
    public String home() {
        return"homePage/home";

    }
    
}
