
package br.edu.poo.m0006.config;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        Connection conexao = Conexao.conectar();

        if (conexao != null) {
            System.out.println("Banco de dados conectado!");

            try {
                conexao.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
