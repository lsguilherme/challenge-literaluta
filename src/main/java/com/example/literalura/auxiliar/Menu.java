package com.example.literalura.auxiliar;

import com.example.literalura.service.AutorService;
import com.example.literalura.service.LivroService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    private final LivroService livroService;
    private final AutorService autorService;

    public Menu(LivroService livroService, AutorService autorService) {
        this.livroService = livroService;
        this.autorService = autorService;
    }

    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 0){
            var menu = """
					Escolha o número da sua opção:
					1. Buscar livro pelo título
					2. Listar livros registrados
					3. Listar autores registrados
					4. Listar autores vivos em um determinado ano
					5. Listar livros em um determinado idioma
					0. Sair
					""";

            System.out.println(menu);

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1:
                    System.out.println("Digite o livro que você quer buscar:");
                    String titulo = sc.nextLine();
                    livroService.cadastrarLivroNoBancoPorTitulo(titulo);
                    break;
                case 2:
                    livroService.buscarLivrosRegistrados();
                    break;
                case 3:
                    autorService.buscarAutoresRegistrados();
                    break;
                case 4:
                    System.out.println("Insira o ano que deseja pesquisar");
                    Integer ano = Integer.parseInt(sc.nextLine());
                    autorService.buscarAutoresVivosEmUmAno(ano);
                    break;
                case 5:
                    System.out.println("""
                            Insira o livro que quer realizar a busca:
                            en - ingles
                            es - espanhol
                            pt - portugues
                            fr - frances
                            """);
                    String idioma = sc.nextLine();
                    livroService.buscarLivroPorIdioma(idioma);
                    break;
            }
        }

    }
}
