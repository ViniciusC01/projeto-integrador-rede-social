package br.com.projetopi.redesocial.tests;

import br.com.projetopi.redesocial.dao.CursoDao;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;

import java.sql.SQLException;

public class CursoTest {

    public static void creatingACourseTest() throws SQLException {
        Instituicao instituicao = new Instituicao();
        instituicao.setNome("Centro Universitário Senac");
        instituicao.setId(1);
        Curso curso = new Curso("Analise e Desenvolvimento de Sistemas", "Presencial", "TI", instituicao, instituicao.getId());

        CursoDao cursoDao = new CursoDao();
        cursoDao.createCurso(curso);
    }
}
