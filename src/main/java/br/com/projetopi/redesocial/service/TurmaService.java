package br.com.projetopi.redesocial.service;

import br.com.projetopi.redesocial.dao.TurmaDao;
import br.com.projetopi.redesocial.interfaces.Service;
import br.com.projetopi.redesocial.model.Turma;

import java.sql.Date;
import java.util.ArrayList;

public class TurmaService implements Service<Turma> {

    private TurmaDao turmaDao;
    public TurmaService(){
        this.turmaDao = new TurmaDao();
    }

    @Override
    public void add(Turma turma) {
        turmaDao.add(turma);
    }

    @Override
    public boolean update(Turma turma) {
        return turmaDao.update(turma);
    }

    @Override
    public boolean remove(int id) {
        return this.remove(id);
    }

    @Override
    public ArrayList findAllPageable(int qtd_elementos, int num_inicio) {
        return this.turmaDao.findAllPageable(qtd_elementos, num_inicio);
    }

    public Turma findTurmaByDataIdCursoSemestre(Date data_inicio, int id_curso, String semestre){
        return this.turmaDao.findTurmaByDataIdCursoSemestre(data_inicio, id_curso, semestre);
    }

    public Turma getById(int id){
        return this.turmaDao.findById(id);
    }
}
