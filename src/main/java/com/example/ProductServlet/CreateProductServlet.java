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

@WebServlet("/product/create")
public class CreateProductServlet extends HttpServlet {
    BasicDao<Product> basicDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/Create/createDrug.jsp").forward(request, response);
        // TODO: 04.05.2021 Change path
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            int cost = Integer.parseInt(request.getParameter("cost"));
            int count = Integer.parseInt(request.getParameter("count"));

            Product product = new Product(name, cost, count);
            basicDao.create(product);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/create").forward(request, response);
            ex.printStackTrace();

        }
    }
}

