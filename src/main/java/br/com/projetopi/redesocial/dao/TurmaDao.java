package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.interfaces.Dao;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class TurmaDao implements Dao<Turma> {
    Connection conexao;

    public TurmaDao(){
        this.conexao = ConnectionFactory.getConnectionH2();
    }
    public void add(Turma turma){
        String sqlQuery = "insert into turma " +
                "(id_curso, data_inicio, turno, semestre, letra)" +
                "values (?,?,?,?,?)";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, turma.getCurso_id());
            ps.setDate(2, turma.getData_inicio());
            ps.setString(3, turma.getTurno());
            ps.setString(4, turma.getSemestre());
            ps.setString(5, turma.getLetra());
            ps.execute();
            conexao.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean update(Turma turma){
        return true;
    }
    public boolean remove(int id){
        return true;
    }
    public ArrayList<Turma> findAllPageable(int qtd_elementos, int num_inicio){
        ArrayList<Turma> turmas = new ArrayList<>();

        String sqlQuery = "SELECT * FROM turma LIMIT ? OFFSET ?;"; //TODO
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setInt(1, qtd_elementos);
            ps.setInt(2, num_inicio);
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Turma turma = new Turma();
                turma.setCurso_id(result.getInt("id_curso"));
                turma.setData_inicio(result.getDate("data_inicio"));
                turma.setLetra(result.getString("letra"));
                turma.setSemestre(result.getString("semestre"));
                turmas.add(turma);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return turmas;
    }
    public Turma findTurmaByDataIdCursoSemestre(Date data_inicio, int id_curso, String semestre){
        String sqlQuery = "select * from turma where year(?) = 2022 and id_curso = ? and semestre = ?";
        Turma turma = new Turma();
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setDate(1, data_inicio);
            ps.setInt(2, id_curso);
            ps.setString(3, semestre);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                turma.setCurso_id(result.getInt("id_curso"));
                turma.setData_inicio(result.getDate("data_inicio"));
                turma.setLetra(result.getString("letra"));
                turma.setSemestre(result.getString("semestre"));
                turma.setTurno(result.getString("turno"));
                turma.setId(result.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return turma;
    }

    public Turma findById(int id){
        String sql =  "SELECT * FROM turma WHERE id = " + id;

        try( PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.execute();
            try(ResultSet set = statement.getResultSet()) {
                while (set.next()) {
                    Turma turma = new Turma();

                    turma.setId(set.getInt("id"));
                    turma.setCurso_id(set.getInt("id_curso"));
                    turma.setTurno(set.getString("turno"));
                    turma.setLetra(set.getString("letra"));
                    turma.setSemestre(set.getString("semestre"));
                    turma.setData_inicio(set.getDate("data_inicio"));

                    return turma;
                }
            }catch (SQLException e){
                System.out.printf(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return null;
    }

}
