
package br.edu.poo.m0006.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL =
            dotenv.get("DB_URL");

    private static final String USUARIO =
            dotenv.get("DB_USER");

    private static final String SENHA =
            dotenv.get("DB_PASSWORD");

    public static Connection conectar() {

        try {
            Connection conexao =
                    DriverManager.getConnection(URL, USUARIO, SENHA);

            return conexao;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: "
                    + e.getMessage());
            return null;
        }
    }
}
