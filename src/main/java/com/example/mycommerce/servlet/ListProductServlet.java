package com.example.servlet;

import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;
import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth/listProduct")
public class ListProductServlet extends HttpServlet {

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MyProduct> products = MyProductDao.getAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/listProduct.jsp");
        rd.forward(req, resp);

    }
}