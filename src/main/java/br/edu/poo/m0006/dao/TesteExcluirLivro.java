
package br.edu.poo.m0006.dao;

public class TesteExcluirLivro {

    public static void main(String[] args) {

        LivroDao livroDAO = new LivroDao();

        livroDAO.excluir(1);

        System.out.println("Teste de exclusão finalizado!");
    }
}
