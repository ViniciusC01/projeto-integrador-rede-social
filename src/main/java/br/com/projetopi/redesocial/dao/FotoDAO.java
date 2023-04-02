package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FotoDAO {

    Connection conexao;

    public FotoDAO() {
        try {
            conexao = ConnectionFactory.getConnectionH2();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void toadd(Foto foto) {
        String sql = "insert into foto (id, cd_foto) values (?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, foto.getId());
            stmt.setLong(2, foto.getCd_foto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean remove(Foto foto) {
        String sql = "DELETE FROM foto WHERE =?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, foto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    boolean update(Foto foto) {
        String sql = "UPDATE FOTO SET cd_foto = ? WHERE =? ";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setLong(1, foto.getId());
            stmt.setInt(2, foto.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
