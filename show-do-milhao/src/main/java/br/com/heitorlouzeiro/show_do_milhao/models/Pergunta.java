package br.com.heitorlouzeiro.show_do_milhao.models;

import java.util.List;

public class Pergunta {
    private Integer id;
    private String pergunta;
    private List<String> opcoes;
    private String resposta_correta;
    private int pontuacao;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public String getresposta_correta() {
        return resposta_correta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.resposta_correta = respostaCorreta;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
