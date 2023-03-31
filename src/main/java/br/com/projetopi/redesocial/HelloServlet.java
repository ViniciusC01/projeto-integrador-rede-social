package br.com.projetopi.redesocial;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.projetopi.redesocial.repository.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try(Connection connectionFactory = ConnectionFactory.getConnectionH2();) {
            System.out.println("Conexão ok");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }
}