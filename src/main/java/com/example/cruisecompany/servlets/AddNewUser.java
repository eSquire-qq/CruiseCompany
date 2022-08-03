package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.cruisecompany.entity.User;

@WebServlet(name = "AddNewUser", value = "/AddNewUser")
public class AddNewUser extends HttpServlet {

    UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/Hello.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        UserRole role = UserRole.USER;

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.setRoleId(role);

        try {
            userDAO.create(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
