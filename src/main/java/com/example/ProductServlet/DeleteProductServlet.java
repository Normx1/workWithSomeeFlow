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

@WebServlet("/product/delete")
public class DeleteProductServlet extends HttpServlet {
    BasicDao<Product> basicDao = new ProductDao();

    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            basicDao.deleteById(id);
            response.sendRedirect("/");
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}