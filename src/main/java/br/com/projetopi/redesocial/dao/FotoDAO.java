package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class FotoDAO{

    Connection conexao;

    public FotoDAO() {
        conexao = ConnectionFactory.getConnectionH2();
    }

    public void toadd(Foto foto) {
        String INSERT = "insert into foto (cd_foto) values (?)";
        try (PreparedStatement statement = conexao.prepareStatement(INSERT)) {

            try {
//                statement.setInt(1, foto.getId());
                statement.setBytes(1, foto.getCd_foto());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean remove(Foto foto) {
        String DELETE = "DELETE FROM foto WHERE id =?";
        try (PreparedStatement stmt = conexao.prepareStatement(DELETE)) {
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

    public Optional<Foto> findById(int id) {
        String select = "SELECT * FROM foto WHERE id =?";
        StringBuilder sb = new StringBuilder();
        ResultSet resultado;

        try (PreparedStatement stmt = conexao.prepareStatement(select)) {
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
                return Optional.of(new Foto(resultado.getInt("id"),
                        resultado.getBytes("cd_foto")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.empty();
    }


}
