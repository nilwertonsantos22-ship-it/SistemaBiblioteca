
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Autor;

public class TesteAutorDao {

    public static void main(String[] args) {

        AutorDao autorDAO = new AutorDao();

        Autor autor = new Autor();

        AutorDao autorDao = new AutorDao();

        if (autorDAO.existe(1)) {
            System.out.println("Autor encontrado!");
        } else {
            System.out.println("Autor não encontrado!");
        }

        autor.setNome("Jorge Amado");
        autor.setNacionalidade("Brasileira");

        autorDAO.cadastrar(autor);

        System.out.println("Teste finalizado!");
    }
}
