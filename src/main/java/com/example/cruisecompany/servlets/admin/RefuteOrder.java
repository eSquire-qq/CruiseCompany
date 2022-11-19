package com.example.cruisecompany.servlets.admin;

import com.example.cruisecompany.dao.UserCruiseDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "RefuteOrder", value = "/RefuteOrder")
public class RefuteOrder extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RefuteOrder.class);

    private static final UserCruiseDAO userCruiseDAO = UserCruiseDAO.getUserCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            userCruiseDAO.refuteUserOrder(id);

        } catch (NumberFormatException e) {
            logger.error("Invalid number format");
        }
        response.sendRedirect("/Orders");
    }

}
