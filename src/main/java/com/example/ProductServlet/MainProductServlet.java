package com.example.ProductServlet;

import com.example.Dao.BasicDao;
import com.example.Dao.ProductDao;
import com.example.Products.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productList")
public class MainProductServlet extends HttpServlet {
    BasicDao<Product> basicDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", basicDao.getAll());
    try{
        getServletContext().getRequestDispatcher("/WEB-INF/product/productList.jsp").forward(req, resp);
    }catch (IOException exception) {
        System.out.println(exception);
    }
    }
}