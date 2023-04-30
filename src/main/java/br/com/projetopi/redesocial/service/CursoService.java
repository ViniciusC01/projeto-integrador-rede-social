package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.CursoDao;
import br.com.projetopi.redesocial.model.Curso;

import java.util.ArrayList;

public class CursoService {
    private CursoDao cursoDao;

    public CursoService(){
        this.cursoDao = new CursoDao();
    }

    public ArrayList<Curso> getCursosByInstituicaoId(int instituicaoId){
        return cursoDao.getCursosByInstituicaoId(instituicaoId);
    }

    public Curso getCursoById(int id){
        return cursoDao.findById(id);
    }

}
