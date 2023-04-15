package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.model.Usuario;

public class UsuarioService {

    UsuarioDao usuarioDao;

    public UsuarioService(){
        this.usuarioDao = new UsuarioDao();
    }

    public void add(Usuario usuario){
        this.usuarioDao.add(usuario);
    }

    public int getIdByEmail(String email){
        int id = usuarioDao.getIdByEmail(email);
        return id;
    }

}
