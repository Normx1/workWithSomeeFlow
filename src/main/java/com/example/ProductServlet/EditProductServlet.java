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

@WebServlet("/product/edit")
public class EditProductServlet extends HttpServlet {
    private BasicDao<Product> basicDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = basicDao.getById(id);
            if (product != null) {
                request.setAttribute("product", product);
                request.getServletContext().getRequestDispatcher("/editProduct.jsp").forward(request, response);
            } else {
                request.setAttribute("id", id);
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }

        } catch (
                Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            ex.printStackTrace();

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String productName = request.getParameter("name");
            int count = Integer.parseInt(request.getParameter("count"));
            int cost = Integer.parseInt(request.getParameter("cost"));
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = new Product(id, productName, cost, count);
            basicDao.updateById(product);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher(request.getContextPath() + "/notfound.jsp").forward(request, response);
            System.out.println("not success" + "  " + ex);
            ex.printStackTrace();

        }
    }
}
