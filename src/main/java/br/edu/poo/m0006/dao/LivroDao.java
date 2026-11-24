
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.config.Conexao;
import br.edu.poo.m0006.model.Livro;
import br.edu.poo.m0006.model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    public void cadastrar(Livro livro) {
        String sql = "INSERT INTO livro (titulo, isbn, ano_publicacao, autor_id) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, livro.getAutor().getId());

            stmt.executeUpdate();
            System.out.println("Livro cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();

        String sql = """
                SELECT l.id, l.titulo, l.isbn, l.ano_publicacao,
                       a.id AS autor_id, a.nome, a.nacionalidade
                FROM livro l
                INNER JOIN autor a ON l.autor_id = a.id
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Autor autor = new Autor(
                        rs.getInt("autor_id"),
                        rs.getString("nome"),
                        rs.getString("nacionalidade")
                );

                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("isbn"),
                        rs.getInt("ano_publicacao"),
                        autor
                );

                livros.add(livro);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }

        return livros;
    }

    public void atualizar(Livro livro) {
        String sql = """
                UPDATE livro
                SET titulo = ?, isbn = ?, ano_publicacao = ?, autor_id = ?
                WHERE id = ?
                """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getIsbn());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, livro.getAutor().getId());
            stmt.setInt(5, livro.getId());

            stmt.executeUpdate();
            System.out.println("Livro atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Livro excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir livro: " + e.getMessage());
        }


    }
    public boolean existeISBN(String isbn) {
        String sql = "SELECT id FROM livro WHERE isbn = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, isbn);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar ISBN: " + e.getMessage());
            return false;
        }
    }

}


