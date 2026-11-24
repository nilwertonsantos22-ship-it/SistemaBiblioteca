
package br.edu.poo.m0006;

import br.edu.poo.m0006.api.OpenLibraryApi;
import br.edu.poo.m0006.dao.AutorDao;
import br.edu.poo.m0006.dao.LivroDao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AutorDao autorDAO = new AutorDao();
        LivroDao livroDAO = new LivroDao();

        int opcao;

        do {
            System.out.println("\n========= SISTEMA DE BIBLIOTECA =========");
            System.out.println("1 - Cadastrar autor");
            System.out.println("2 - Listar autores");
            System.out.println("3 - Atualizar autor");
            System.out.println("4 - Excluir autor");
            System.out.println("5 - Cadastrar livro");
            System.out.println("6 - Listar livros");
            System.out.println("7 - Atualizar livro");
            System.out.println("8 - Excluir livro");
            System.out.println("9 - Pesquisar livro na Open Library");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.nextLine();
                opcao = -1;
            }
            switch (opcao) {


                case 1:
                    System.out.println("\n--- CADASTRAR AUTOR ---");

                    System.out.print("Nome do autor: ");
                    String nome = scanner.nextLine();

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    br.edu.poo.m0006.model.Autor autor =
                            new br.edu.poo.m0006.model.Autor();

                    if (nome.trim().isEmpty() || nacionalidade.trim().isEmpty()) {
                        System.out.println("Erro: nome e nacionalidade são obrigatórios!");
                    } else {
                        autor.setNome(nome);
                        autor.setNacionalidade(nacionalidade);

                        autorDAO.cadastrar(autor);
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE AUTORES ---");

                    for (br.edu.poo.m0006.model.Autor a : autorDAO.listar()) {
                        System.out.println("----------------------");
                        System.out.println("ID: " + a.getId());
                        System.out.println("Nome: " + a.getNome());
                        System.out.println("Nacionalidade: " + a.getNacionalidade());
                    }

                    break;


                case 3:
                    System.out.println("\n--- ATUALIZAR AUTOR ---");

                    System.out.print("Digite o ID do autor: ");
                    int idAutor = lerInteiro(scanner);

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Nova nacionalidade: ");
                    String novaNacionalidade = scanner.nextLine();

                    br.edu.poo.m0006.model.Autor autorAtualizado =
                            new br.edu.poo.m0006.model.Autor();

                    autorAtualizado.setId(idAutor);
                    autorAtualizado.setNome(novoNome);
                    autorAtualizado.setNacionalidade(novaNacionalidade);

                    autorDAO.atualizar(autorAtualizado);
                    break;


                case 4:
                    System.out.println("\n--- EXCLUIR AUTOR ---");

                    System.out.print("Digite o ID do autor: ");
                    int idExcluir = lerInteiro(scanner);

                    autorDAO.excluir(idExcluir);
                    break;



                case 5:
                    System.out.println("\n--- CADASTRAR LIVRO ---");

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Ano de publicação: ");
                    int ano = lerInteiro(scanner);

                    System.out.print("ID do autor: ");
                    int idDoAutor = lerInteiro(scanner);

                    br.edu.poo.m0006.model.Autor autorLivro =
                            new br.edu.poo.m0006.model.Autor();

                    autorLivro.setId(idDoAutor);

                    br.edu.poo.m0006.model.Livro novoLivro =
                            new br.edu.poo.m0006.model.Livro();

                    novoLivro.setTitulo(titulo);
                    novoLivro.setIsbn(isbn);
                    novoLivro.setAnoPublicacao(ano);
                    novoLivro.setAutor(autorLivro);

                    if (titulo.trim().isEmpty() || isbn.trim().isEmpty()
                            || ano <= 0 || idDoAutor <= 0) {

                        System.out.println("Erro: preencha todos os campos corretamente!");

                    } else if (!autorDAO.existe(idDoAutor)) {

                        System.out.println("Erro: autor não encontrado no sistema!");

                    } else if (livroDAO.existeISBN(isbn)) {

                        System.out.println("Erro: este ISBN já está cadastrado!");

                    } else {

                        livroDAO.cadastrar(novoLivro);

                    }
                    break;



                case 6:
                    System.out.println("\n--- LISTA DE LIVROS ---");

                    for (br.edu.poo.m0006.model.Livro l : livroDAO.listar()) {
                        System.out.println("-------------------------");
                        System.out.println("ID: " + l.getId());
                        System.out.println("Título: " + l.getTitulo());
                        System.out.println("ISBN: " + l.getIsbn());
                        System.out.println("Ano: " + l.getAnoPublicacao());
                        System.out.println("Autor: " + l.getAutor().getNome());
                    }

                    break;



                case 7:
                    System.out.println("\n--- ATUALIZAR LIVRO ---");

                    System.out.print("ID do livro: ");
                    int idLivro = lerInteiro(scanner);

                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print("Novo ISBN: ");
                    String novoIsbn = scanner.nextLine();

                    System.out.print("Novo ano de publicação: ");
                    int novoAno = lerInteiro(scanner);

                    System.out.print("Novo ID do autor: ");
                    int novoIdAutor = lerInteiro(scanner);

                    br.edu.poo.m0006.model.Autor AutorAtualizado =
                            new br.edu.poo.m0006.model.Autor();

                    AutorAtualizado.setId(novoIdAutor);

                    br.edu.poo.m0006.model.Livro livroAtualizado =
                            new br.edu.poo.m0006.model.Livro();

                    livroAtualizado.setId(idLivro);
                    livroAtualizado.setTitulo(novoTitulo);
                    livroAtualizado.setIsbn(novoIsbn);
                    livroAtualizado.setAnoPublicacao(novoAno);
                    livroAtualizado.setAutor(AutorAtualizado);

                    livroDAO.atualizar(livroAtualizado);
                    break;



                case 8:
                    System.out.println("\n--- EXCLUIR LIVRO ---");

                    System.out.print("Digite o ID do livro: ");
                    int idExcluirLivro = lerInteiro(scanner);

                    livroDAO.excluir(idExcluirLivro);
                    break;


                case 9:
                    System.out.println("\n--- PESQUISAR LIVRO NA OPEN LIBRARY ---");

                    System.out.print("Digite o título ou ISBN do livro: ");
                    String pesquisa = scanner.nextLine();

                    OpenLibraryApi api =
                            new OpenLibraryApi();

                    api.buscarLivro(pesquisa);
                    break;



                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
    public static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite apenas números.");
            scanner.nextLine();
            System.out.print("Tente novamente: ");
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }

}
