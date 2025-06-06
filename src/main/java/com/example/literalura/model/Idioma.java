package com.example.literalura.model;

public enum Idioma {
    ES("es","Espanhol"),
    EN("en","Inglês"),
    FR("fr","Francês"),
    PT("pt","Português");

    private final String codigoGutendex;
    private final String idiomaEmTexto;

    Idioma(String codigoGutendex, String idiomaEmTexto) {
        this.codigoGutendex = codigoGutendex;
        this.idiomaEmTexto = idiomaEmTexto;
    }

    public String getCodigoGutendex() {
        return codigoGutendex;
    }

    public String getIdiomaEmTexto() {
        return idiomaEmTexto;
    }
}
