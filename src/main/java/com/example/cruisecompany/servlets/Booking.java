package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Booking", value = "/Booking")
public class Booking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");

        UserCruiseDAO userCruiseDAO = UserCruiseDAO.getUserCruiseInstance();
        UserCruise userCruise = new UserCruise();

        userCruise.setCruiseId(id);
        userCruise.setUserId(user.getId());

        userCruiseDAO.create(userCruise);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Booking.jsp");
        requestDispatcher.forward(request,response);
    }
}
