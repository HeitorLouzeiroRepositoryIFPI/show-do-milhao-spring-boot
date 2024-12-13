package br.com.heitorlouzeiro.show_do_milhao.controller;

import br.com.heitorlouzeiro.show_do_milhao.models.Usuario;
import br.com.heitorlouzeiro.show_do_milhao.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeControler {

    @Autowired // Injetar o repositório automaticamente
    private Repositorio repositorio;

    @GetMapping("/")
    public String home(Model model) {
        List<Usuario> usuarios = repositorio.findTop10ByRanking();
        model.addAttribute("usuarios", usuarios);
        return "homePage/home";
    }

    @PostMapping("/start")
    public String start(@RequestParam("nickname") String nickname, Model model) {
        model.addAttribute("nickname", nickname);
        return "redirect:/perguntas?nickname=" + nickname;
    }
}