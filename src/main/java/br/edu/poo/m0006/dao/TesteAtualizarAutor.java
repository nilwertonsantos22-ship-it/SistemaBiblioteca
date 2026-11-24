
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Autor;

public class TesteAtualizarAutor {

    public static void main(String[] args) {

        AutorDao autorDAO = new AutorDao();

        Autor autor = new Autor();

        autor.setId(1);
        autor.setNome("Jorge Amado");
        autor.setNacionalidade("Brasileira");

        autorDAO.atualizar(autor);

        System.out.println("Teste de atualização finalizado!");
    }
}
