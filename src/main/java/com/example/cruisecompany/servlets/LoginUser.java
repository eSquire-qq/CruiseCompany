package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserLoginDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {

    public LoginUser() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/HomePage.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        if(UserLoginDAO.getUserLoginInstance().dataVerification(phoneNumber,password)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
            requestDispatcher.forward(request,response);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginUser.jsp");
        requestDispatcher.forward(request,response);

    }
}
