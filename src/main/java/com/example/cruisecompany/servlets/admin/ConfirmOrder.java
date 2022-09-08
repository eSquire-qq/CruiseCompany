package com.example.cruisecompany.servlets.admin;

import com.example.cruisecompany.dao.UserCruiseDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConfirmOrder", value = "/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {

    private static final UserCruiseDAO userCruiseDAO = UserCruiseDAO.getUserCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            userCruiseDAO.confirmUserOrder(id);

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/Orders");
    }
}

