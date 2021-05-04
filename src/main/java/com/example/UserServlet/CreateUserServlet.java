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

@WebServlet("/user/create")
public class CreateUserServlet extends HttpServlet {

    BasicDao<User> userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(1);
        try {
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            String password = request.getParameter("password");
            User users = new User(name, password, mail);
            userDao.create(users);
            response.sendRedirect(request.getContextPath() + "/");
        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
//            getServletContext().getRequestDispatcher("/create").forward(request, response);
        }
    }
}
