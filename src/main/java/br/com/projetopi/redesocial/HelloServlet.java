package br.com.projetopi.redesocial;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.projetopi.redesocial.repository.ConnectionFactory;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try(Connection connectionFactory = ConnectionFactory.getConnection();) {
            System.out.println("Deu certo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}