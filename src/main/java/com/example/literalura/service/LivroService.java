package com.example.literalura.service;

import com.example.literalura.config.HttpService;
import com.example.literalura.dto.AutorDto;
import com.example.literalura.dto.LivroDto;
import com.example.literalura.dto.RequestDto;
import com.example.literalura.model.Autor;
import com.example.literalura.model.Livro;
import com.example.literalura.repository.AutorRepository;
import com.example.literalura.repository.LivroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    @Value("${gutendex.api.url.titulo}")
    private String apiUrlTitulo;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    public void cadastrarLivroNoBancoPorTitulo(String titulo) {
        Optional<Livro> livroExistente = livroRepository.findFirstByTituloContainingIgnoreCase(titulo);

        if (livroExistente.isPresent()) {
            imprimirLivro(livroExistente.get());
            return;
        }

        String respostaJson = buscarTituloNaApi(titulo);
        Livro livro = converterJsonParaLivro(respostaJson);
        livroRepository.save(livro);
        Optional<Livro> livroSalvo = livroRepository.findFirstByTituloContainingIgnoreCase(titulo);
        livroSalvo.ifPresent(this::imprimirLivro);
    }

    private void imprimirLivro(Livro livro) {
        System.out.printf("""
        ----- Livro -----
        Título: %s
        Autor: %s
        Idioma: %s
        Número de downloads: %d
        ------------------
        """,
                livro.getTitulo(),
                livro.getAutor().getNome(),
                livro.getIdioma().toString().toLowerCase(),
                livro.getDownloads()
        );
    }
    private String buscarTituloNaApi(String titulo) {
        String tituloReplace = titulo.replace(" ", "%20");
        return HttpService.request(apiUrlTitulo + tituloReplace);
    }

    public void buscarLivrosRegistrados() {
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        livros.forEach(this::imprimirLivro);
    }

    public void buscarLivroPorIdioma() {
        System.out.println("Listando livros em um determinado idioma");
    }

    private Livro converterJsonParaLivro(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            RequestDto dto = mapper.readValue(json, RequestDto.class);

            if (dto.livros() == null || dto.livros().isEmpty()) {
                throw new RuntimeException("Nenhum livro encontrado na resposta da API.");
            }

            LivroDto livroDto = dto.livros().stream().findFirst().orElseThrow(() -> new RuntimeException("Nenhum livro encontrado na API."));
            AutorDto autorDto = livroDto.autor().stream().findFirst().orElseThrow(() -> new RuntimeException(("Nenhum autor encontrado para esse livro.")));

            Autor autor = autorRepository
                    .findByNomeIgnoreCase(autorDto.nome())
                    .orElseGet(() -> autorRepository.save(autorDto.toAutor()));


            return dto.livros().getFirst().toLivro(autor);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao processar resposta da API", e);
        }
    }
}
