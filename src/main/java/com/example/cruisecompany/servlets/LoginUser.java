package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserLoginDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.jms.Session;
import java.io.IOException;

import static com.example.cruisecompany.database.PasswordHashCode.hashPassword;

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {

    public LoginUser() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LoginUser.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        if(UserLoginDAO.getUserLoginInstance().dataVerification(phoneNumber,hashPassword(password))){
            HttpSession session = null;
            session.setAttribute("users",phoneNumber);
            response.sendRedirect("/HomePage.jsp");
        }

    }
}
