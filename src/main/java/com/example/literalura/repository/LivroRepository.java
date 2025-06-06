package com.example.literalura.repository;

import com.example.literalura.model.Idioma;
import com.example.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findFirstByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByIdioma(Idioma idioma);
}
