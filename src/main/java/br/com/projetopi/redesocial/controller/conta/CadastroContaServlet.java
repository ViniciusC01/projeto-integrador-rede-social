package br.com.projetopi.redesocial.controller.conta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/conta_cadastrar")
public class CadastroContaServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // dados usuario

        String email = req.getParameter("email");
        String senha = req.getParameter("papel");
        String papel = req.getParameter("papel");

        String cpf = req.getParameter("senha");
        String nome = req.getParameter("nome");
        String data_nascimento = req.getParameter("data_nascimento");
        String sobre = req.getParameter("sobre");
        String usuario_id = req.getParameter("usuario_id");
        String instituicao_id = req.getParameter("instituicao_id");
        String curso_id = req.getParameter("curso_id");
        String foto_id = req.getParameter("foto_id");
        String turma_id = req.getParameter("turma_id");

        req.getRequestDispatcher("./register.html").forward(req,resp);
    }
}
