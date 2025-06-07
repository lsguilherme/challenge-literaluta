package com.example.literalura.service;

import com.example.literalura.model.Autor;
import com.example.literalura.model.Livro;
import com.example.literalura.repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public void buscarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(this::imprimirAutor);
    }

    @Transactional
    public void buscarAutoresVivosEmUmAno(Integer ano) {
        List<Autor> autores = autorRepository.autoresVivos(ano);
        autores.forEach(this::imprimirAutor);
    }

    private void imprimirAutor(Autor autor){
        List<String> livros = autor.getLivros().stream().map(Livro::getTitulo).toList();
        System.out.printf("""
                Autor: %s
                Ano de nascimento: %s
                Ano de falecimento: %s
                Livros: %s
                
                """, autor.getNome(), autor.getAnoNascimento(), autor.getAnoMorte(), livros);
    }

}
