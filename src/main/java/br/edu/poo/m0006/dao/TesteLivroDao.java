
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Autor;
import br.edu.poo.m0006.model.Livro;

public class TesteLivroDao {

    public static void main(String[] args) {

        Autor autor = new Autor();
        autor.setId(1);

        Livro livro = new Livro();
        livro.setTitulo("O Cortiço");
        livro.setIsbn("9788535910663");
        livro.setAnoPublicacao(1890);
        livro.setAutor(autor);

        LivroDao livroDAO = new LivroDao();
        livroDAO.cadastrar(livro);
    }
}
