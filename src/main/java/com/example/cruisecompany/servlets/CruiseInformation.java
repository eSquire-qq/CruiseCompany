package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CruiseInformation", value = "/Information")
public class CruiseInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Long id = Long.valueOf(request.getParameter("id"));
        UserCruiseDAO userCruiseDao = UserCruiseDAO.getUserCruiseInstance();
        userCruiseDao.addToOrder(id);

        Cruise cruise = userCruiseDao.addToOrder(id);
        request.getSession().setAttribute("cruise",cruise);

        session.setAttribute("cruise_id", id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CruiseInformation.jsp");
        requestDispatcher.forward(request,response);
    }
}
