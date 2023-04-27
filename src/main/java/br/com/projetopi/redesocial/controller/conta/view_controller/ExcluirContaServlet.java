package br.com.projetopi.redesocial.controller.conta.view_controller;

import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirContaServlet extends HttpServlet {

    private ContaService contaService;

    ExcluirContaServlet(){
        this.contaService = new ContaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));
        this.contaService.remove(id);
    }
}
