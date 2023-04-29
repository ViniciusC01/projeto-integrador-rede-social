package br.com.projetopi.redesocial.controller;

import br.com.projetopi.redesocial.dao.FotoDAO;
import br.com.projetopi.redesocial.model.Foto;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/exemplo-servlet")
@MultipartConfig
public class TesteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("teste.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodo = req.getParameter("_method");
        if (metodo != null && metodo.equalsIgnoreCase("delete")) {
            doDelete(req, resp);
            return;
        }
        if (metodo != null && metodo.equalsIgnoreCase("put")) {
            doPut(req, resp);
            return;
        }
        if (metodo != null && metodo.equalsIgnoreCase("uploadimg")) {
            service(req, resp);
            return;
        }


        Part img = req.getPart("img");
        String id = req.getParameter("id");
        InputStream dadosEmBytes = img.getInputStream();
        byte [] dados = dadosEmBytes.readAllBytes();
        Foto ft = new Foto();
        ft.setId(Integer.parseInt(id));
        ft.setCd_foto(dados);
        new FotoDAO().toadd(ft);

        req.getRequestDispatcher("teste.html").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_delete");
//        System.out.println("ID:" + id);
        Foto foto = new Foto();
        foto.setId(Integer.parseInt(id));
        new FotoDAO().remove(foto);

        req.getRequestDispatcher("teste.html").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_put");
        Part img = req.getPart("img");
        InputStream dadosEmBytes = req.getInputStream();
        byte[] dados = dadosEmBytes.readAllBytes();

        Foto foto = new Foto();
        foto.setId(Integer.parseInt(id));
        foto.setCd_foto(dados);
        new FotoDAO().update(foto);

        req.getRequestDispatcher("teste.html").forward(req,resp);
    }
}