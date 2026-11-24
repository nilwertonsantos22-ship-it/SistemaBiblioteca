
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.model.Livro;
import br.edu.poo.m0006.model.Autor;

public class TesteAtualizarLivro {

    public static void main(String[] args) {

        Livro livro = new Livro();
        livro.setId(1);
        livro.setTitulo("O Cortiço - Edição Atualizada");
        livro.setIsbn("9788535910663");
        livro.setAnoPublicacao(1890);

        Autor autor = new Autor();
        autor.setId(1);

        livro.setAutor(autor);

        LivroDao livroDAO = new LivroDao();
        livroDAO.atualizar(livro);
    }
}
