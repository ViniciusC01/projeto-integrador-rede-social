package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.service.InstituicaoService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/api_instituicoes")
public class InstituicaoApi extends HttpServlet {

    InstituicaoService instituicaoService;
    public InstituicaoApi(){
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Instituicao> instituicoes = this.instituicaoService.getInstituicaoAll(10, 0);
        String json = ApiUtils.ObjectToJsonString(instituicoes);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
