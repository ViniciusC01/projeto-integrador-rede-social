package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Usuario;

import java.util.ArrayList;

public class UsuarioService implements Service<Usuario> {

    UsuarioDao usuarioDao;

    public UsuarioService(){
        this.usuarioDao = new UsuarioDao();
    }

    public void add(Usuario usuario){
        this.usuarioDao.add(usuario);
    }

    @Override
    public boolean update(Usuario object) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return null;
    }


    public int getIdByEmail(String email){
        int id = usuarioDao.getIdByEmail(email);
        return id;
    }

}
