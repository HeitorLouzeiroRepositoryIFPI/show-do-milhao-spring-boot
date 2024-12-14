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

    private final ObjectMapper objectMapper;
    private List<Pergunta> perguntas;

    public PerguntaService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/utils/perguntas.json");
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: /utils/perguntas.json");
        }
        try {
            perguntas = objectMapper.readValue(inputStream, new TypeReference<List<Pergunta>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar perguntas do arquivo JSON", e);
        }
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }
}