package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.example.cruisecompany.entity.User;

@WebServlet(name = "AddNewUser", value = "/AddNewUser")
public class AddNewUser extends HttpServlet {

     UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/HomePage.jsp");
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

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("id",name);
        System.out.println(httpSession.getAttribute("id"));

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.setRole(role);
        user.setPassword(password);
        user.setEmail(email);

    }

}
