package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public int getIdByEmail(String email) {
        String sqlQuery = "select * from usuario where email = ?";
        try(PreparedStatement ps = conexao.prepareStatement(sqlQuery)){
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();
            Usuario usuario = new Usuario();
            while(result.next()){
                usuario.setEmail(result.getString("email"));
                usuario.setPapel(result.getString("papel"));
                usuario.setSenha(result.getString("senha"));
                usuario.setId(result.getInt("id"));
            }
            return usuario.getId();
        }catch (Exception e){
            System.out.println("Erro " + e.getMessage());
            return 0;
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

    public void remove(Usuario usuario) {
        String sqlQuery = "DELETE FROM usuario WHERE id =?";
        try {PreparedStatement ps = conexao.prepareStatement(sqlQuery);
            ps.setInt(1,usuario.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();

        }
    }




}
