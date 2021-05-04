package com.example.UserServlet;

import com.example.Dao.BasicDao;
import com.example.Dao.UserDao;
import com.example.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

    BasicDao<User> userBasicDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //Отличие sendRedirect  и forward в том что 1 показывает url не полный а 2 полный путь, вроде так
            int id = Integer.parseInt(request.getParameter("id"));
            userBasicDao.deleteById(id);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
