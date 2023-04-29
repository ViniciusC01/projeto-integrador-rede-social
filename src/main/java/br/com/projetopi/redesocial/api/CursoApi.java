package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.controller.CursoServlet;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.util.ApiUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Utilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/api_cursos")
public class CursoApi extends HttpServlet {
    private CursoService cursoService;

    public CursoApi(){
        this.cursoService = new CursoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int instituicaoId = Integer.valueOf(req.getParameter("instituicao_id"));
        ArrayList<Curso> cursos = cursoService.getCursosByInstituicaoId(instituicaoId);
        String json = ApiUtils.ObjectToJsonString(cursos);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
