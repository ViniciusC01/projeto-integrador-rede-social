package br.com.projetopi.redesocial.controller.admin.view;

import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/excluir_conta")
public class AdminServlet extends HttpServlet {

//    private ContaService contaService;
//
//    public AdminServlet(){
//        this.contaService = new ContaService();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));

        ContaService contaService = new ContaService();
        contaService.remove(id);
        req.getRequestDispatcher("/admin").forward(req, resp);

        //contaService.remove(id);
    }
}
