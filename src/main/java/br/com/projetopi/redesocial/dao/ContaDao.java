package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;

public class ContaDao {

    Connection conexao;
    public ContaDao(){
        try {
            this.conexao = ConnectionFactory.getConnectionH2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(Conta conta) throws SQLException {
        String sqlQuery = "insert into conta " +
                "(cpf, nome, data_nascimento, sobre, usuario_id, instituiacao_id, curso_id, foto_id, turma_id)" +
                "values (?,?,?,?,?,?,?,?,?)";

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {

            ps.setString(1, conta.getCpf());
            ps.setString(2, conta.getNome());
            ps.setDate(3, conta.getData_nascimento());
            ps.setString(4, conta.getSobre());
            ps.setInt(5, conta.getUsuario_id());
            ps.setInt(6, conta.getInstituiacao_id());
            ps.setInt(7, conta.getCurso_id());
            ps.setInt(8, conta.getFoto_id());
            ps.setInt(9, conta.getTurma_id());

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void update(int id){

    }
    public boolean remove(){
        String sqlQuery = "delete from conta where id == ?";
        try(Statement st = conexao.createStatement()){
            st.execute(sqlQuery);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public void findAll(int qtd_elementos, int pagina){

        String sqlQuery = "select * from conta where limit ?"; //TODO

    }

    public Conta findById(int id){

        String sqlQuery = "select * from conta where id == ?";
        ResultSet result;
        Conta conta = new Conta();

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            result = ps.executeQuery();

            while(result.next()){
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituiacao_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return conta;

    }


}
