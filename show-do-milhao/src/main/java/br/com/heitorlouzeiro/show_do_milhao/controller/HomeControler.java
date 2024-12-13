package br.com.heitorlouzeiro.show_do_milhao.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeControler {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
}
