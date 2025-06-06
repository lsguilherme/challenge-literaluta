package com.example.literalura.service;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    public void buscarLivroNaApi(){
        System.out.println("Buscando livro");
    }

    public void buscarLivrosRegistrados(){
        System.out.println("Listando livros registrados");
    }

    public void buscarLivroPorIdioma() {
        System.out.println("Listando livros em um determinado idioma");
    }
}
