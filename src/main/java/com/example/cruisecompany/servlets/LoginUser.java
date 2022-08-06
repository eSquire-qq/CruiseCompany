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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/index.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        try {
            if(UserLoginDAO.getUserLoginInstance().DataVerification(phoneNumber,password)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginUser.jsp");
        requestDispatcher.forward(request,response);

    }
}
