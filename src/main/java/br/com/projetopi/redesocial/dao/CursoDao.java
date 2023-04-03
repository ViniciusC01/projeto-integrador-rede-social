package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDao {

    private Connection connection;

    public CursoDao() {
        try{
            this.connection = ConnectionFactory.getConnectionH2();
        } catch(SQLException e){
           e.printStackTrace();
        }

    }

    public void createCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO curso(NOME, TIPO, AREA, INSTITUICAO_ID) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, curso.getNome());
        statement.setString(2, curso.getTipo());
        statement.setString(3, curso.getArea());
        statement.setInt(4, curso.getInstituicao_id());

        statement.execute();
        System.out.println("Curso incluido com sucesso!");
    }


}
