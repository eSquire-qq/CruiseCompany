package com.example.cruisecompany.servlets.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminLanguage", value = "/AdminLanguage")
public class AdminLanguage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");
        request.getSession().setAttribute("language",language);
        response.sendRedirect("/AdminHomePage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
