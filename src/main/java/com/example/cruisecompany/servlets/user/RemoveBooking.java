package com.example.cruisecompany.servlets.user;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.UserCruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveBooking", value = "/RemoveBooking")
public class RemoveBooking extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long ticketId = Long.valueOf(request.getParameter("ticketId"));

        UserCruiseDAO userCruiseDAO = UserCruiseDAO.getUserCruiseInstance();
        UserCruise userCruise = new UserCruise();

        userCruise.setTicketId(ticketId);
        userCruiseDAO.delete(ticketId);

        response.sendRedirect("/UserProfile");
    }

}
