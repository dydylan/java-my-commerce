package com.example.mycommerce.servlet;

import com.example.mycommerce.dao.DaoFactory;
import com.example.mycommerce.dao.MyProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = Long.parseLong(req.getParameter("id"));
        MyProductDao mpd = DaoFactory.getCarDao();
        mpd.removeProduct(id);
        RequestDispatcher rs = req.getRequestDispatcher("/auth/listProduct");
        rs.forward(req,resp);

    }
}