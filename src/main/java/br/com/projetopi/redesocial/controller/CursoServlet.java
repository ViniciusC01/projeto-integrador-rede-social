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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Instituicao instituicao = new Instituicao();
//        instituicao.setNome("Senac");
//
//        InstituicaoDao instituicaoDao = new InstituicaoDao();
//        instituicaoDao.add(instituicao);
//
//        Curso curso = new Curso("ADS", "EAD", "TI", instituicao, instituicao.getId());
//        CursoDao cursoDao = new CursoDao();
//
//        try{
//            cursoDao.createCurso(curso);
//            List<Curso> cursos = cursoDao.findAll();
//            cursos.forEach(x -> System.out.println(x));
//
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
