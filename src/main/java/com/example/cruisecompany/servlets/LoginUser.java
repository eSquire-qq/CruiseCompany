package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.dao.UserLoginDAO;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {

    public LoginUser() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        if(UserLoginDAO.DataVerification(phoneNumber,password)){
            response.sendRedirect("index.jsp");
        }

        response.sendRedirect("LoginUser.jsp");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
