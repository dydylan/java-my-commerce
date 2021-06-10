package com.example.mycommerce.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.mycommerce.dao.DaoFactory;
import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProduct product = new MyProduct();
        product.setName("Montre");
        product.setContent("belle montre");
        product.setPrice(150F);
        MyProductDao mpd = DaoFactory.getCarDao();
        mpd.addProduct(product);
    }
}