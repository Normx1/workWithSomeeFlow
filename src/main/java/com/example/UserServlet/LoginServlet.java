//package com.example.UserServlet;
//
//import com.example.Connector.JDBCConnector;
//import com.example.Dao.BasicDao;
//import com.example.Dao.UserDao;
//import com.example.User.User;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
// BasicDao<User> basicDao = new UserDao();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");
//        String rememberMeStr = req.getParameter("rememberMe");
//        boolean remember = "Y".equals(rememberMeStr);
//
//
//        User user = null;
//        boolean hasError = false;
//        String errorString = null;
//
//        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
//            hasError = true;
//            errorString = "Required username and password!";
//        } else {
//            user = basicDao.getById(id)
//