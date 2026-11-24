
package br.edu.poo.m0006.dao;

public class TesteExcluirAutor {

    public static void main(String[] args) {

        AutorDao autorDAO = new AutorDao();

        autorDAO.excluir(5);

        System.out.println("Teste de exclusão finalizado!");
    }
}
