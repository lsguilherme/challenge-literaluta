package com.example.literalura.dto;

import com.example.literalura.model.Autor;
import com.example.literalura.model.Idioma;
import com.example.literalura.model.Livro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDto(
        @JsonAlias("title")
        String titulo,

        @JsonAlias("languages")
        List<Idioma> idiomas,

        @JsonAlias("download_count")
        Integer downloads,

        @JsonAlias("authors")
        List<AutorDto> autor
) {
        public Livro toLivro(Autor autor) {
                Livro livro = new Livro();
                livro.setTitulo(this.titulo());
                livro.setDownloads(this.downloads());
                livro.setIdioma(this.idiomas().getFirst());
                livro.setAutor(autor);
                return livro;
        }
}
