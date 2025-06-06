package com.example.literalura.service;

import org.springframework.stereotype.Service;

@Service
public class AutorService {

    public void buscarAutoresRegistrados() {
        System.out.println("Listando autores registrados");
    }

    public void buscarAutoresVivosEmUmAno() {
        System.out.println("Listando autores vivos em um determinado ano");
    }
}
