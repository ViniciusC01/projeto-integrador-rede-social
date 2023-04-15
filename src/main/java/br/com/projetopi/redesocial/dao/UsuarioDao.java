package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
    Connection conexao;
    public UsuarioDao(){
        try {
            this.conexao = ConnectionFactory.getConnectionH2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(Usuario usuario){
        String sqlQuery = "insert into usuario " +
                "(email, senha, papel)" +
                "values (?,?,?,?)";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getPapel());
            ps.execute();
        }catch (SQLException e){
            System.out.printf("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

}
