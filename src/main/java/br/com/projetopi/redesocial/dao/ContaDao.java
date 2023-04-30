package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class ContaDao {

    Connection conexao;
    public ContaDao(){
        try {
            this.conexao = ConnectionFactory.getConnectionH2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(Conta conta){
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
    public boolean update(Conta conta){
        String sqlQuery = """
            update conta 
            set 
                cpf = ?,
                nome = ?,
                data_nascimento = ?,
                sobre = ?,
                usuario_id = ?,
                instituiacao_id = ?,
                curso_id = ?,
                foto_id = ?,
                turma_id = ?
            where id  = ?
        """;
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
            ps.setInt(10, conta.getId());
        }catch (SQLException e){
            System.out.println("Ocorreu o erro " + e);;
            return false;
        }
        return true;
    }
    public boolean remove(int id){
        String sqlQuery = "update conta set ic_ativo = ? where id = ?";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, 0);
            ps.setInt(2, id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Conta> findAllPageable(int qtd_elementos, int num_inicio){

        ArrayList<Conta> contas = new ArrayList<>();

        String sqlQuery = "SELECT * FROM conta where ic_ativo = ?  LIMIT ? OFFSET ?;"; //TODO
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setInt(1, 1);
            ps.setInt(2, qtd_elementos);
            ps.setInt(3, num_inicio);

            ResultSet result = ps.executeQuery();

            while(result.next()){
                Conta conta = new Conta();
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituicao_id"));
                conta.setCurso_id(result.getInt("curso_id"));
                conta.setFoto_id(result.getInt("foto_id"));
                conta.setTurma_id(result.getInt("turma_id"));
                conta.setId(result.getInt("id"));
                contas.add(conta);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contas;
    }

    public Conta findById(int id){

        String sqlQuery = "select * from conta where id = ?";
        ResultSet result;
        Conta conta = new Conta();

        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setInt(1, id);
            result = ps.executeQuery();

            while(result.next()){
                conta.setCpf(result.getString("cpf"));
                conta.setNome(result.getString("nome"));
                conta.setData_nascimento(result.getDate("data_nascimento"));
                conta.setGenero(result.getString("genero"));
                conta.setSobre(result.getString("sobre"));
                conta.setUsuario_id(result.getInt("usuario_id"));
                conta.setInstituiacao_id(result.getInt("instituicao_id"));
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
