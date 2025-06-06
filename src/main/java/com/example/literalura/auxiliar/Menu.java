package com.example.literalura.auxiliar;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void exibeMenu(){
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
                case 1 -> System.out.println("Buscando livro");
                case 2 -> System.out.println("Listando livros registrados");
                case 3 -> System.out.println("Listando autores registrados");
                case 4 -> System.out.println("Listando autores vivos em um determinado ano");
                case 5 -> System.out.println("Listando livros em um determinado idioma");
            }
        }

    }
}
