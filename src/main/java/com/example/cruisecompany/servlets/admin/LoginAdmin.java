package com.example.cruisecompany.servlets.admin;

import com.example.cruisecompany.dao.UserLoginDAO;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginAdmin", value = "/LoginAdmin")
public class LoginAdmin extends HttpServlet {

    public LoginAdmin() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login/LoginAdmin.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            User admin = UserLoginDAO.dataVerification(email,password);
            if(admin != null){
                if(UserLoginDAO.userVerification(email, password).equals(String.valueOf(2))){
                    request.getSession().setAttribute("admin",admin);
                    response.sendRedirect("/AdminHomePage");
                }
            }else {
                request.getSession().setAttribute("LoginError","Incorrect email or password");
                response.sendRedirect("/LoginAdmin");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
