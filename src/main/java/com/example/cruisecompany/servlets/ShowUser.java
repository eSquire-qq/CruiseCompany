package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ShowUser", value = "/ShowUser")
public class ShowUser extends HttpServlet {

    UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] users = new String[]{"Tom", "Bob", "Sam"};
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/HomePage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
