package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.ContaDao;
import br.com.projetopi.redesocial.dao.InstituicaoDao;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Instituicao;

import java.util.ArrayList;

public class ContaService {

    ContaDao contaDao;

    public ContaService(){
        contaDao = new ContaDao();
    }

    public ArrayList<Conta> getContaAll(int qtd_elementos, int num_inico){
        return contaDao.findAllPageable(qtd_elementos, num_inico);
    }

    public Conta getContaById(int id){
        return contaDao.findById(id);
    }
}
