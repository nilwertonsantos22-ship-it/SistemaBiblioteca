
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Autor;

import java.util.List;

public class TesteListarAutores {

    public static void main(String[] args) {

        AutorDao autorDAO = new AutorDao();

        List<Autor> autores = autorDAO.listar();

        System.out.println("=== LISTA DE AUTORES ===");

        for (Autor autor : autores) {

            System.out.println("ID: " + autor.getId());
            System.out.println("Nome: " + autor.getNome());
            System.out.println("Nacionalidade: " + autor.getNacionalidade());

            System.out.println("----------------------");
        }
    }
}
