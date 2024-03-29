package com.example.cruisecompany.servlets.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogOutUser", value = "/LogOutUser")
public class LogOutUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(false);
        request.getSession(false).invalidate();
        request.getSession(false);

        response.sendRedirect("/HomePage");
    }
}
