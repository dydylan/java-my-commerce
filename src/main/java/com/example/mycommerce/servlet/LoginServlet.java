package com.example.mycommerce.servlet;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String utilisateur = req.getParameter("name");

        HttpSession session = req.getSession();
        session.setAttribute("user",utilisateur);
        resp.sendRedirect( req.getContextPath() + "/auth/addProduct");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd =
                req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }
}