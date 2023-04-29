package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.model.dto.ContaEditarDto;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.service.InstituicaoService;
import br.com.projetopi.redesocial.service.TurmaService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api_conta_editar")
public class ContaEditarApi extends HttpServlet {

    private ContaService contaService;
    private CursoService cursoService;
    private TurmaService turmaService;
    private InstituicaoService instituicaoService;

    public ContaEditarApi(){
        this.contaService = new ContaService();
        this.cursoService = new CursoService();
        this.turmaService = new TurmaService();
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.valueOf(req.getParameter("id"));
        Conta conta = this.contaService.getContaById(id);
        Instituicao instituicao = this.instituicaoService.getInstituicaoById(conta.getInstituiacao_id());
        Curso curso = this.cursoService.getCursoById(conta.getCurso_id());
        Turma turma = this.turmaService.getById(conta.getTurma_id());

        ContaEditarDto contaEditarDto = new ContaEditarDto(
                conta.getCpf(),
                conta.getNome(),
                conta.getData_nascimento(),
                conta.getGenero(),
                instituicao.getNome(),
                curso.getNome(),
                turma.getLetra()
        );

        String json = ApiUtils.ObjectToJsonString(contaEditarDto);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
