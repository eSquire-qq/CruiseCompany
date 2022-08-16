package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.example.cruisecompany.entity.User;

import static com.example.cruisecompany.database.PasswordHashCode.hashPassword;

@WebServlet(name = "AddNewUser", value = "/AddNewUser")
public class AddNewUser extends HttpServlet {

     UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AddUser.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        UserRole role = UserRole.USER;
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.setRole(role);
        user.setPassword(hashPassword(password));
        user.setEmail(email);

        if(!userDAO.register(phoneNumber,email)) {
            response.getWriter().print("email or password already exist");

        }

        userDAO.create(user);

        response.sendRedirect("/HomePage.jsp");

        // TODO must be servlet

    }
}
