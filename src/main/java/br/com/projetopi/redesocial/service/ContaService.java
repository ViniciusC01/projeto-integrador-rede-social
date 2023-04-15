package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.ContaDao;
import br.com.projetopi.redesocial.dao.CursoDao;
import br.com.projetopi.redesocial.dao.InstituicaoDao;
import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaService {

    private ContaDao contaDao;
    private UsuarioDao usuarioDao;

    public ContaService(){

        this.contaDao = new ContaDao();
        this.usuarioDao = new UsuarioDao();
    }

    public ArrayList<Conta> getContaAll(int qtd_elementos, int num_inico){
        return contaDao.findAllPageable(qtd_elementos, num_inico);
    }

    public Conta getContaById(int id){
        return contaDao.findById(id);
    }

    public boolean add(Conta conta) {
        this.contaDao.add(conta);
        return true;
    }
}
