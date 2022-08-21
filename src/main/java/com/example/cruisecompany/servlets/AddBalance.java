package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddBalance", value = "/AddBalance")
public class AddBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/AddBalance.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        try {

            Long id = user.getId();
            double balance = user.getBalance();
            int newBalance = Integer.parseInt(request.getParameter("balance"));

            UserDAO.addBalance(balance, id, newBalance);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/UserProfile");
    }
}
