package br.com.projetopi.redesocial.controller;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/conta")
public class ContaServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // teste conta list all

        ContaService contaService = new ContaService();
        ArrayList<Conta> contas = contaService.getContaAll(10, 0);
        for(Conta conta: contas){
            System.out.println(conta);
        }

        // teste conta busca por id

        Conta conta = contaService.getContaById(1);
        System.out.println(conta);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
