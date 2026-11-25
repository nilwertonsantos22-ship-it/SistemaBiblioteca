# Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando Programação Orientada a Objetos, MySQL e integração com a API pública Open Library.

## Objetivo

Desenvolver um sistema para cadastrar, consultar, atualizar e excluir autores e livros, mantendo o relacionamento entre essas entidades no banco de dados.

## Tecnologias utilizadas

- Java 26
- Maven
- MySQL 8
- JDBC
- dotenv-java
- Jackson
- Open Library API
- Git e GitHub

## Funcionalidades

### Gerenciamento de autores
- Cadastrar autores.
- Listar autores.
- Atualizar autores.
- Excluir autores.

### Gerenciamento de livros
- Cadastrar livros.
- Listar livros.
- Atualizar livros.
- Excluir livros.
- Relacionar livros aos seus respectivos autores.

### Pesquisa de livros
- Pesquisar livros pelo título ou ISBN.
- Consultar informações bibliográficas na Open Library API.
- Exibir título, autor, editora, ano e ISBN quando disponíveis.

## Banco de dados

O projeto utiliza MySQL com duas tabelas principais:

- `autor`: armazena nome e nacionalidade.
- `livro`: armazena título, ISBN, ano de publicação e o identificador do autor.

A tabela `livro` possui uma chave estrangeira que referencia a tabela `autor`.

## Configuração do ambiente

### Pré-requisitos

- Java JDK 26.
- Maven.
- MySQL Server 8.
- IntelliJ IDEA ou outra IDE compatível.

### 1. Clonar o repositório

```bash
git clone git clone https://github.com/nilwertonsantos22-ship-it/SistemaBiblioteca

```

### 2. Criar o banco de dados

No MySQL, execute:

```sql
CREATE DATABASE sistema_biblioteca;
```

### 3. Configurar as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto, utilizando o `.env.example` como referência.

Configure:

```env
DB_URL=jdbc:mysql://localhost:3306/sistema_biblioteca
DB_USER=root
DB_PASSWORD=sua_senha
```

Substitua `sua_senha` pela senha configurada no seu MySQL.

**Importante:** não publique o arquivo `.env`, pois ele contém informações privadas.

### 4. Executar o projeto

Abra o projeto na IDE, aguarde a sincronização do Maven e execute a classe:

`br.edu.poo.m0006.Main`


### Estrutura do banco de dados

O projeto disponibiliza o script SQL em `database/schema.sql`, contendo a criação do banco de dados `sistema_biblioteca` e das tabelas `autor` e `livro`, incluindo o relacionamento entre elas por chave estrangeira.

Para configurar o banco em uma instalação nova:

1. Abra o MySQL Workbench.
2. Conecte-se ao servidor MySQL.
3. Abra o arquivo `database/schema.sql`.
4. Execute o script para criar o banco e as tabelas.

        
## Organização do projeto

```text
src/
 └── main/
     ├── java/
     │   └── br/edu/poo/m0006/
     │       ├── api/
     │       ├── config/
     │       ├── dao/
     │       ├── model/
     │       ├── service/
     │       └── Main.java
     └── resources/

.env
.env.example
.gitignore
pom.xml
README.md
```

## Integração externa

A pesquisa de livros utiliza a Open Library Search API:

https://openlibrary.org/dev/docs/api/search

## Autor

Desenvolvido por Nilwerton Santos.

Projeto acadêmico de Programação Orientada a Objetos.