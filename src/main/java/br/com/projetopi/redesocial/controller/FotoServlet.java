package br.com.projetopi.redesocial.controller;

import br.com.projetopi.redesocial.dao.FotoDAO;
import br.com.projetopi.redesocial.model.Foto;
import br.com.projetopi.redesocial.service.FotoService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/foto")
@MultipartConfig
public class FotoServlet extends HttpServlet {
    private FotoService fotoService;
    private static final long serialVersionUID = 1L;

    public FotoServlet() {
        this.fotoService = new FotoService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String id = req.getParameter("id_get");
        Optional<Foto> ft = new FotoDAO().findById(Integer.parseInt(id));

        if (ft.isPresent()) {
            byte[] dados = ft.get().getCd_foto();
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(ft.get().getCd_foto());
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part img = req.getPart("img");
        InputStream dadosEmBytes = img.getInputStream();
        byte [] dados = dadosEmBytes.readAllBytes();
        fotoService.add(new Foto(dados));
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_delete");
        new FotoDAO().remove(new Foto(Integer.parseInt(id),null));
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part img = req.getPart("img");
        String id = req.getParameter("id_put");

        InputStream dadosEmBytes = img.getInputStream();
        byte[] dados = dadosEmBytes.readAllBytes();
        fotoService.update(new Foto(Integer.parseInt(id),dados));
    }
}