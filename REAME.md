# 📚 Literalura

Uma aplicação que consome a API do [Gutendex](https://gutendex.com/) para preencher uma base de dados com livros e seus respectivos autores.

## 🧾 Descrição do Projeto

Literalura é um sistema simples, desenvolvido em Java, que conecta-se à API pública do Gutendex para registrar livros e autores em uma base de dados PostgreSQL. A aplicação também permite buscas e listagens com base em critérios específicos, como idioma ou período de vida dos autores.

## ✨ Funcionalidades

- Buscar livro pelo título.
- Listar livros registrados.
- Listar autores registrados.
- Listar autores vivos em um determinado ano.
- Listar livros em um determinado idioma.

## 🛠 Requisitos

- Java 21 ou superior
- PostgreSQL 17 ou superior

## 🔧 Acesso ao Projeto

1. Clone o repositório:
```
git clone https://github.com/lsguilherme/challenge-literaluta.git
```
2. Configure as variáveis de ambiente para conexão com o banco de dados:
```
${DB_HOST}      # Ex: localhost:5432
${DB_NAME}      # Nome do banco de dados
${DB_USER}      # Usuário do banco de dados
${DB_PASSWORD}  # Senha do banco de dados
```
3. Acesse o arquivo:
```
src/main/java/com/example/literalura/LiteraluraApplication.java
```
4. Rode o método **main** para iniciar a aplicação.
