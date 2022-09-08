package com.example.cruisecompany.servlets.user;

import com.example.cruisecompany.dao.UserLoginDAO;
import com.example.cruisecompany.entity.User;
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login/LoginUser.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            User user = UserLoginDAO.dataVerification(email,password);

            if(user != null){
                if(UserLoginDAO.userVerification(email, password).equals(String.valueOf(0))){
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect("/UserProfile");
                }
            }else{
                request.getSession().setAttribute("LoginError","Incorrect email or password");
                response.sendRedirect("/LoginUser");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
