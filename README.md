Preparei a documentação considerando nosso projeto, Java 26, Maven, MySQL e as duas entidades: Autor e Livro.
Writing{variant="document" id="63821"}
# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido em Java, como parte do Desafio Extra da disciplina de Programação Orientada a Objetos (POO).

O projeto procura aplicar os conceitos de Programação Orientada a Objetos, operações CRUD, integração com banco de dados e consumo de API externa.

## 🎯 Objetivo do Projeto

Desenvolver uma aplicação que permita gerenciar autores e livros, mantendo o relacionamento entre essas entidades e armazenando os dados em um banco de dados MySQL.

## 🛠️ Tecnologias Utilizadas

- Java 26
- Maven
- MySQL
- JDBC
- Git e GitHub
- API ViaCEP (integração prevista)

## 📋 Funcionalidades

O sistema terá as seguintes funcionalidades:

### Gerenciamento de Autores
- Cadastrar autores.
- Listar autores.
- Atualizar dados dos autores.
- Excluir autores.

### Gerenciamento de Livros
- Cadastrar livros.
- Listar livros.
- Atualizar dados dos livros.
- Excluir livros.
- Relacionar livros aos seus respectivos autores.

### Integração
- Conexão com banco de dados MySQL.
- Consumo de API externa.
- Armazenamento de configurações por meio de arquivo `.env`.

## 🗂️ Estrutura do Projeto

```text
SistemaBiblioteca/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/edu/poo/m0006/
│   │   │       ├── api/
│   │   │       ├── config/
│   │   │       ├── dao/
│   │   │       ├── model/
│   │   │       │   ├── Autor.java
│   │   │       │   └── Livro.java
│   │   │       ├── service/
│   │   │       └── Main.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── .env.example
├── .gitignore
├── pom.xml
└── README.md
```

## ⚙️ Requisitos para execução

Antes de executar o projeto, é necessário ter instalado:

- JDK 26.
- Apache Maven.
- MySQL Server.
- IntelliJ IDEA ou outra IDE compatível com Java.

## 🚀 Instalação e execução

1. Clone o repositório:

```bash
git clone https://github.com/nilwertonsantos22-ship-it/SistemaBiblioteca.git
```

2. Entre na pasta do projeto:

```bash
cd SistemaBiblioteca
```

3. Configure o banco de dados MySQL.

4. Crie o arquivo `.env` na raiz do projeto, utilizando o `.env.example` como referência.

5. Configure suas credenciais de acesso ao banco de dados.

6. Abra o projeto no IntelliJ IDEA e aguarde a sincronização do Maven.

7. Execute a classe `Main.java`.

## 🔐 Configuração do ambiente

As configurações de acesso ao banco de dados serão armazenadas no arquivo `.env`, evitando deixar informações sensíveis diretamente no código-fonte.

O arquivo `.env.example` apresentará os nomes das variáveis necessárias para configurar o ambiente.

**Importante:** o arquivo `.env` real não deve ser enviado ao GitHub.

## 🗄️ Banco de Dados

O projeto utilizará o MySQL para armazenar as informações de autores e livros.

As operações de cadastro, consulta, atualização e exclusão serão realizadas por meio de JDBC.

## 👨‍💻 Desenvolvedor

José Nílwerton dos Santos da Silva


Projeto individual desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

## 📌 Status do Projeto

🚧 Em desenvolvimento.

## 📅 Entrega

Desafio Extra de Programação Orientada a Objetos.

Prazo: 05 de dezembro de 2026.
