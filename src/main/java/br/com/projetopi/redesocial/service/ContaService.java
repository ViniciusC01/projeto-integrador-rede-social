package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.ContaDao;
import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Conta;

import java.util.ArrayList;

public class ContaService implements Service<Conta> {

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

    public void add(Conta conta) {
        this.contaDao.add(conta);
    }

    @Override
    public boolean update(Conta object) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        this.contaDao.remove(id);
        return true;
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return null;
    }


}
