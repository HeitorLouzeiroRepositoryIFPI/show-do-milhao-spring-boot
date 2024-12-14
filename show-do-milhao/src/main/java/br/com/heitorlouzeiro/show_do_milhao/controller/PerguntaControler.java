package br.com.heitorlouzeiro.show_do_milhao.controller;

import br.com.heitorlouzeiro.show_do_milhao.models.Pergunta;
import br.com.heitorlouzeiro.show_do_milhao.models.Usuario;
import br.com.heitorlouzeiro.show_do_milhao.service.PerguntaService;
import br.com.heitorlouzeiro.show_do_milhao.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public class PerguntaControler {

    @Autowired
    private PerguntaService perguntaService;

    @Autowired
    private Repositorio repositorio;

    @GetMapping("/perguntas")
    public String listarPerguntas(@RequestParam("nickname") String nickname, Model model) {
        List<Pergunta> perguntas = perguntaService.getPerguntas();
        Collections.shuffle(perguntas); // Embaralha a lista de perguntas
        model.addAttribute("perguntas", perguntas);
        model.addAttribute("nickname", nickname);
        return "perguntas/lista";
    }

    @GetMapping("/api/perguntas")
    @ResponseBody
    public List<Pergunta> getPerguntas() {
        return perguntaService.getPerguntas();
    }

    @PostMapping("/salvarPontuacao")
    public String salvarPontuacao(@RequestParam("nickname") String nickname, @RequestParam("pontuacao") int pontuacao, Model model) {
        Usuario usuario = new Usuario();
        usuario.setNickname(nickname);
        usuario.setPontuacao(pontuacao);
        usuario.setData(LocalDateTime.now());
        repositorio.save(usuario);
        model.addAttribute("pontuacao", pontuacao);
        return "perguntas/pontuacao";
    }
}