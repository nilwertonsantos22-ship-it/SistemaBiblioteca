
package br.edu.poo.m0006.dao;

import br.edu.poo.m0006.config.Conexao;
import br.edu.poo.m0006.model.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    public void cadastrar(Autor autor) {

        String sql = "INSERT INTO autor (nome, nacionalidade) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());

            stmt.executeUpdate();

            System.out.println("Autor cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Autor> listar() {

        List<Autor> autores = new ArrayList<>();

        String sql = "SELECT * FROM autor";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Autor autor = new Autor();

                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setNacionalidade(rs.getString("nacionalidade"));

                autores.add(autor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;
    }

    public void atualizar(Autor autor) {

        String sql = "UPDATE autor SET nome = ?, nacionalidade = ? WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setInt(3, autor.getId());

            stmt.executeUpdate();

            System.out.println("Autor atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM autor WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Autor excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

            public boolean existe (int id) {
                String sql = "SELECT id FROM autor WHERE id = ?";

                try (Connection conexao = Conexao.conectar();
                     PreparedStatement stmt = conexao.prepareStatement(sql)) {

                    stmt.setInt(1, id);

                    try (ResultSet rs = stmt.executeQuery()) {
                        return rs.next();
                    }

                } catch (SQLException e) {
                    System.out.println("Erro ao consultar autor: " + e.getMessage());
                    return false;
                }
            }
        }
