package com.example.cruisecompany.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminHomePage", value = "/AdminHomePage")
public class AdminHomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/AdminHomePage.jsp");
        requestDispatcher.forward(request,response);
    }
}
