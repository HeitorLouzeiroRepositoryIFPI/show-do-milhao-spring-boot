package br.com.heitorlouzeiro.show_do_milhao.service;

import br.com.heitorlouzeiro.show_do_milhao.models.Pergunta;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PerguntaService {

    private List<Pergunta> perguntas;

    @PostConstruct
    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Pergunta>> typeReference = new TypeReference<List<Pergunta>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("utils/perguntas.json");
        try {
            perguntas = objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar perguntas do arquivo JSON", e);
        }
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}