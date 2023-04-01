package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public Instituicao update(){

        //TODO

        return null;
    }

    public ArrayList<Instituicao> findAllPageble(){
        return null; // TODO
    }

    public Instituicao find(){
        return null; // TODO
    }

}
