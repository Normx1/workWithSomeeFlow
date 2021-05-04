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

@WebServlet ("/userList")
public class MainUserServlet extends HttpServlet {
    BasicDao<User> basicDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", basicDao.getAll());
        try {
            getServletContext().getRequestDispatcher("/WEB-INF/user/userList.jsp").forward(req, resp);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}