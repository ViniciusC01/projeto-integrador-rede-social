package br.com.projetopi.redesocial.controller;

import br.com.projetopi.redesocial.dao.CursoDao;
import br.com.projetopi.redesocial.dao.InstituicaoDao;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/curso")
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //TESTA METODO FIND ALL
        try{
            Instituicao instituicao = new Instituicao();
            instituicao.setNome("Teste");

            InstituicaoDao instituicaoDao = new InstituicaoDao();
            instituicaoDao.add(instituicao);

            Curso curso = new Curso("ADS", "EAD", "TI", instituicao, instituicaoDao.getId(instituicao));
            CursoDao cursoDao = new CursoDao();

            cursoDao.createCurso(curso);
            List<Curso> cursos = cursoDao.findAll();
            cursos.forEach(x -> System.out.println(x));

            req.setAttribute("curso", cursos.get(0).getNome());
            req.getRequestDispatcher("curso.jsp").forward(req, resp);

        } catch(SQLException e) {
            e.printStackTrace();
        }


    }
}
