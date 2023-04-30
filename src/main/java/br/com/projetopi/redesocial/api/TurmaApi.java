package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.service.TurmaService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/api_turma_specific")
public class TurmaApi extends HttpServlet {

    private TurmaService turmaService;

    public TurmaApi(){
        this.turmaService = new TurmaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int ano_inicio = Integer.valueOf(req.getParameter("ano_inicio"));
        String semestre = req.getParameter("semestre");
        String turno = req.getParameter("turno");
        int id = Integer.valueOf(req.getParameter("id_curso"));

        Turma turma = this.turmaService.findTurmaByDataIdCursoSemestre(ano_inicio, id, semestre, turno);
        String json = ApiUtils.ObjectToJsonString(turma);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
