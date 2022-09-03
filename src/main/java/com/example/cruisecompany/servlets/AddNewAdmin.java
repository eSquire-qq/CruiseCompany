package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static com.example.cruisecompany.service.PasswordHashCode.hashPassword;

@WebServlet(name = "AddNewAdmin", value = "/AddNewAdmin")
public class AddNewAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/AddAdmin.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        UserRole role = UserRole.ADMINISTRATOR;
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            if (UserDAO.getUserInstance().userPhoneEquals(phoneNumber)
                && UserDAO.getUserInstance().userEmailEquals(email)){

                User user = new User();

                user.setName(name);
                user.setSurname(surname);
                user.setPhoneNumber(phoneNumber);
                user.setRole(role);
                user.setPassword(hashPassword(password));
                user.setEmail(email);

                response.sendRedirect("/HomePage");

                request.getSession().setAttribute("user", user);

            }
        }catch (Exception e){
            throw new IOException();
        }
    }
}
