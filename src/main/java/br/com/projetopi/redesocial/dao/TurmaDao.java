package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.interfaces.Dao;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.repository.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;

public class TurmaDao implements Dao<Turma> {
    Connection conexao;

    public TurmaDao(){
        this.conexao = ConnectionFactory.getConnectionH2();
    }
    public void add(Turma turma){

    }
    public boolean update(Turma turma){
        return true;
    }
    public boolean remove(int id){
        return true;
    }
    public ArrayList<Turma> findAllPageable(int qtd_elementos, int num_inicio){
        return null;
    }

}
