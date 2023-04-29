package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {

    private Connection connection;

    public CursoDao() {
        this.connection = ConnectionFactory.getConnectionH2();
    }
    public void createCurso(Curso curso) throws SQLException {
        boolean cursoExists = cursoExists(curso);

        if(!cursoExists){
            String sql = "INSERT INTO curso(NOME, TIPO, AREA, INSTITUICAO_ID) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, curso.getNome());
            statement.setString(2, curso.getTipo());
            statement.setString(3, curso.getArea());
            statement.setInt(4,curso.getInstituicao_id());

            statement.execute();

            try(ResultSet rs = statement.getGeneratedKeys()){
                while(rs.next()){
                    curso.setId(rs.getInt(1));
                }
            }
        }
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

    public Curso findById(int id)  {
        String sql =  "SELECT * FROM curso WHERE id = " + id;

        try( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
            try(ResultSet set = statement.getResultSet()) {
                while (set.next()) {
                    Instituicao instituicao = new Instituicao();
                    instituicao.setId(set.getInt(5));
                    Curso curso = new Curso(set.getInt(1), set.getString(2), set.getString(3),
                            set.getString(4), instituicao, instituicao.getId());
                    return curso;
                }
            }catch (SQLException e){
                System.out.printf(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return null;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM curso WHERE id = " + id;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

    private boolean cursoExists(Curso curso) throws SQLException {
        String sql = " SELECT EXISTS(SELECT * FROM CURSO WHERE nome = ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, curso.getNome());
        preparedStatement.execute();

        try( ResultSet rst = preparedStatement.getResultSet()){
            while(rst.next()){
                return rst.getBoolean(1);
            }
        }
        return false;
    }


    public ArrayList<Curso> getCursosByInstituicaoId(int instituicaoId) {
        String sqlQuery = "select * from curso where instituicao_id = ?";
        ArrayList<Curso> cursos = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(sqlQuery)){
            ps.setInt(1, instituicaoId);
            ResultSet result = ps.executeQuery();
            while(result.next()){

                Curso curso = new Curso();
                curso.setTipo(result.getString("tipo"));
                curso.setNome(result.getString("nome"));
                curso.setArea(result.getString("area"));
                curso.setId(result.getInt("id"));

                cursos.add(curso);

            }
            return cursos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return cursos;
    }
}
