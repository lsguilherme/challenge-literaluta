package com.example.literalura.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Idioma {
    ES("es"),
    EN("en"),
    FR("fr"),
    PT("pt");

    private final String codigoGutendex;

    Idioma(String codigoGutendex) {
        this.codigoGutendex = codigoGutendex;
    }

    public String getCodigoGutendex() {
        return codigoGutendex;
    }

    @JsonCreator
    public static Idioma fromValue(String value){
        for(Idioma idioma : Idioma.values()){
            if(idioma.getCodigoGutendex().equalsIgnoreCase(value)){
                return idioma;
            }
        }
        return null;
    }
}
