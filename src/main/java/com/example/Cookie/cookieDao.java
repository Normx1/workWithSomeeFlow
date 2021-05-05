package com.example.Cookie;

import com.example.User.User;
import sun.rmi.transport.Connection;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "CookieFilter", urlPatterns = {"/*"})
public class cookieDao {
    public static final String Att_Name_Connection = "ATTRIBUTE_FOR_CONNECTION";
    public static final String Att_Name_User_Name = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";


    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(Att_Name_Connection, conn);
    }

    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(Att_Name_Connection);
        return conn;
    }

    public static void storeLoginUser(HttpSession session, User logUser) {
        session.setAttribute("logUser", logUser);
    }

    public static User getLogUser(HttpSession session) {
        User logUser = (User) session.getAttribute("logUser");
        return logUser;
    }

    public static void storeUserCookie(HttpServletResponse response, User user){
        Cookie cookieUser = new Cookie(Att_Name_User_Name,user.getName());
        cookieUser.setMaxAge(24*60*60);
        response.addCookie(cookieUser);
    }

    public static String getUserNameInCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies!= null ){
            for (Cookie cookie: cookies
                 ) {
                return cookie.getValue();

            }
        }
        return null;
    }

    public static void deleteUserCookie( HttpServletResponse response){
        Cookie cookie = new Cookie(Att_Name_User_Name, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}

