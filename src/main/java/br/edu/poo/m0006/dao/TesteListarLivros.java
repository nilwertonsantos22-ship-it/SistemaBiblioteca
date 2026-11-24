
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Livro;

import java.util.List;

public class TesteListarLivros {

    public static void main(String[] args) {

        LivroDao livroDAO = new LivroDao();

        List<Livro> livros = livroDAO.listar();

        for (Livro livro : livros) {
            System.out.println("-------------------------");
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("ISBN: " + livro.getIsbn());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Autor: " + livro.getAutor().getNome());
        }
    }
}
