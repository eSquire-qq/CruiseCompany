package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateCruise", value = "/UpdateCruise")
public class UpdateCruise extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/UpdateCruise.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cruise cruise;

        cruise = (Cruise) request.getSession().getAttribute("cruise");

        CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
        cruiseDAO.update(cruise);

        request.getSession().setAttribute("cruise",cruise);

        session.setAttribute("cruise", cruise);

    }
}
