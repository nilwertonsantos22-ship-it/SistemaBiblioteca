
package br.edu.poo.m0006.api;

public class TesteOpenLibrary {

    public static void main(String[] args) {

        OpenLibraryApi api = new OpenLibraryApi();

        System.out.println("=== PESQUISA GOOGLE BOOKS ===");

        api.buscarLivro("Dom Casmurro");
    }
}
