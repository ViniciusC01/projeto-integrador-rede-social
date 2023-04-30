package br.com.projetopi.redesocial.controller.admin.view;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin")
public class AdminHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ContaService contaService = new ContaService();
        ArrayList<Conta> conta = contaService.getContaAll(10, 0);
        req.setAttribute("contas", conta);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }
}
