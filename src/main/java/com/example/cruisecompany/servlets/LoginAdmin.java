package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserLoginDAO;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "LoginAdmin", value = "/LoginAdmin")
public class LoginAdmin extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginAdmin.class);

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

            User user = UserLoginDAO.dataVerification(email,password);
            if(user != null){
                if(UserLoginDAO.userVerification(email, password).equals(String.valueOf(2))){
                    response.sendRedirect("/AdminHomePage");

                }else{

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
