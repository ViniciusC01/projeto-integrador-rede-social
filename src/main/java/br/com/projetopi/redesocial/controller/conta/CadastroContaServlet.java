package br.com.projetopi.redesocial.controller.conta;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Locale;

@WebServlet("/conta_cadastrar")
public class CadastroContaServlet  extends HttpServlet {


    UsuarioService usuarioService;
    ContaService contaService;

    public CadastroContaServlet(){
        this.contaService = new ContaService();
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id;
        try{
            // dados usuario
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            String papel = "Aluno";
            Usuario usuario = new Usuario(email, senha, papel);
            id = usuarioService.getIdByEmail(email);
        }catch (Exception e){
            throw new ServletException("Erro ao cadastrar usuário");
        }

        try{
        String cpf = req.getParameter("cpf"); // TODO CRIAR
        String nome = req.getParameter("nome");
        String data_nascimento = req.getParameter("data_nascimento");
        String sobre = req.getParameter("sobre");// TODO CRIAR
        String instituicao_id = req.getParameter("instituicao_id");
        String curso_id = req.getParameter("curso_id");
        String foto_id = req.getParameter("foto_id");
        String turma_id = req.getParameter("turma_id");

        Conta conta = new Conta();
        conta.setCpf(cpf);
        conta.setNome(nome);
        conta.setData_nascimento(Date.valueOf(data_nascimento));
        conta.setSobre(sobre);
        conta.setUsuario_id(Integer.valueOf(id));
        conta.setInstituiacao_id(Integer.valueOf(instituicao_id));
        conta.setCurso_id(Integer.valueOf(curso_id));
        conta.setFoto_id(Integer.valueOf(foto_id));
        conta.setTurma_id(Integer.valueOf(turma_id));
        ContaService contaService = new ContaService();

        contaService.insert(conta, usuario);
        req.setAttribute("cadastro", "sucesso");

        System.out.println("Erro: " + e.getMessage());
        req.setAttribute("cadastro", "fracasso");

        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            req.setAttribute("cadastro", "fracasso");
        }

        req.getRequestDispatcher("./register.html").forward(req,resp);
    }
}
