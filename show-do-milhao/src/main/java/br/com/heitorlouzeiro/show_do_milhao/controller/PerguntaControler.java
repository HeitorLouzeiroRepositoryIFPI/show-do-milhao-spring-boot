package br.com.heitorlouzeiro.show_do_milhao.controller;

import br.com.heitorlouzeiro.show_do_milhao.models.Pergunta;
import br.com.heitorlouzeiro.show_do_milhao.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class PerguntaControler {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/perguntas")
    public String listarPerguntas(@RequestParam("nickname") String nickname, Model model) {
        List<Pergunta> perguntas = perguntaService.getPerguntas();
        Collections.shuffle(perguntas); // Embaralha a lista de perguntas
        model.addAttribute("perguntas", perguntas);
        model.addAttribute("nickname", nickname);
        return "perguntas/lista";
    }
}