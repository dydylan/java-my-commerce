package com.example.mycommerce.servlet;

import com.example.mycommerce.dao.DaoFactory;
import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addProduct.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct nproduct = new MyProduct();
        nproduct.setName(req.getParameter("name"));
        nproduct.setContent(req.getParameter("content"));
        String nprice = req.getParameter("price");
        Float lprice =0f;
        try{
            lprice = Float.parseFloat(nprice);
        }catch (Exception e){}

        nproduct.setPrice(lprice);
        MyProductDao mpd = DaoFactory.getCarDao();
        mpd.addProduct(nproduct);
        resp.sendRedirect( req.getContextPath() + "/auth/listProduct");

    }
}