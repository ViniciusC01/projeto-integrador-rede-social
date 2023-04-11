package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        statement.setInt(4,curso.getInstituicao_id());

        statement.execute();
        //System.out.println("Curso incluido com sucesso!");
    }

    public void update(Curso curso, Curso cursoToUpdate) throws SQLException{
        String sql = "UPDATE curso SET nome = ? tipo = ? area = ? instituicao_id = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, curso.getNome());
        statement.setString(2, curso.getTipo());
        statement.setString(3, curso.getArea());
        statement.setInt(4, curso.getInstituicao_id());

        statement.execute();
    }

    public List<Curso> findAll() throws SQLException {
        String sql = "SELECT * FROM curso";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        try(ResultSet rst = statement.getResultSet()){
            List<Curso> cursos = new ArrayList<>();
            while(rst.next()){
                cursos.add(new Curso(rst.getInt(1), rst.getString(2), rst.getNString(3), rst.getString(4), null, rst.getInt(5)));
            }
            return cursos;
        }
    }

}
