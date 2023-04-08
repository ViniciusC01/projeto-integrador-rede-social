package br.com.projetopi.redesocial.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rede_social", "root", "root123");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar a conexão");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver de conexão não encontrado");
        }
    }

    public static Connection getConnectionH2() throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar a conexão");
        }
    }
}
