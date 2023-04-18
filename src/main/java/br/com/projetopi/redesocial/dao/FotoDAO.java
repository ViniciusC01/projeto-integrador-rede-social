package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoDAO extends HttpServlet {

    Connection conexao;

    public FotoDAO() {
        try {
            conexao = ConnectionFactory.getConnectionH2();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void toadd(Foto foto) {
        String save = "insert into foto (id, cd_foto) values (?,?)";
        try (PreparedStatement statement = conexao.prepareStatement(save)) {

            try {
                statement.setInt(1, foto.getId());
                statement.setBytes(2, foto.getCd_foto());
                statement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(Foto foto) {
        String sql = "DELETE FROM foto WHERE id =?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, foto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean update(Foto foto) {
        String update = "UPDATE foto SET cd_foto = ? WHERE id =? ";
        try (PreparedStatement stmt = conexao.prepareStatement(update)) {
            stmt.setBytes(1, foto.getCd_foto());
            stmt.setInt(2, foto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String consultaPorId(int id) {
        String select = "SELECT * FROM foto WHERE id =?";
        StringBuilder sb = new StringBuilder();
        ResultSet resultado;
        String s = null;
        Foto ft = new Foto();

        try (PreparedStatement stmt = conexao.prepareStatement(select)) {
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();

            resultado.next();
            ft.setId(resultado.getInt("id"));
//            ft.setCd_foto(resultado.getLong("cd_foto"));

            s = String.valueOf(resultado.getInt("id"));
//                        + String.valueOf(resultado.getBigDecimal("cd_foto")));

            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return s;
    }


}
