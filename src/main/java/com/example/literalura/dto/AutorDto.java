package com.example.literalura.dto;

import com.example.literalura.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorDto(
        @JsonAlias("name")
        String nome,

        @JsonAlias("birth_year")
        Integer anoNascimento,

        @JsonAlias("death_year")
        Integer anoMorte
) {
    public Autor toAutor() {
        Autor autor = new Autor();
        autor.setNome(this.nome());
        autor.setAnoNascimento(this.anoNascimento());
        autor.setAnoMorte(this.anoMorte());
        return autor;
    }
}
