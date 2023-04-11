package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class InstituicaoDao {
    private int id;
    private String nome;

    private Connection con;

    public InstituicaoDao(){
        try {
            this.con = ConnectionFactory.getConnectionH2();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void add(Instituicao instituicao){
        String sqlQuery = "insert into instituicao (nome) values (?)";
        try(PreparedStatement ps =  con.prepareStatement(sqlQuery)){
            ps.setString(1, instituicao.getNome());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean remove(int id){
        String sqlQuery = "delete from instituicao where id == ?";
        try(PreparedStatement ps =  con.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Instituicao instituicao){

        String sqlQuery = """
            update instituicao 
            set 
                nome = ?
            where id  = ?
        """;
        try(PreparedStatement ps = con.prepareStatement(sqlQuery)) {
            ps.setString(1, instituicao.getNome());
            ps.setInt(2, instituicao.getId());
        }catch (SQLException e){
            System.out.println("Ocorreu o erro " + e);;
            return false;
        }
        return true;
    }

    public Instituicao findById(int id){

        ResultSet result;
        Instituicao instituicao = new Instituicao();

        String sqlQuery = "select * from conta where id == ?";
        try(PreparedStatement ps = con.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            result = ps.executeQuery();
            while(result.next()){
                instituicao.setNome(result.getString("nome"));
                instituicao.setId(result.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return instituicao;
    }

    public ArrayList<Instituicao> findAllPageble(int qtd_elementos, int num_inicio){
        ArrayList<Instituicao> instituicoes = new ArrayList<>();

        String sqlQuery = "SELECT * FROM instituicao LIMIT ? OFFSET ?;"; //TODO
        try(PreparedStatement ps = con.prepareStatement(sqlQuery)) {
            ps.setInt(1, qtd_elementos);
            ps.setInt(2, num_inicio);
            ResultSet result = ps.executeQuery();

            while(result.next()){
                Instituicao instituicao = new Instituicao();
                instituicao.setNome(result.getString("nome"));
                instituicao.setId(result.getInt("id"));
                instituicoes.add(instituicao);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return instituicoes;
    }

    public int getId(Instituicao instituicao) throws SQLException {
        String sql = "SELECT * FROM instituicao WHERE nome = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, instituicao.getNome());
        statement.execute();

        try(ResultSet resultSet = statement.getResultSet()){
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
        }
        return 0;
    }


}
