package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateCruise", value = "/UpdateCruise")
public class UpdateCruise extends HttpServlet {
    private final CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cruise cruise = cruiseDAO.read(Long.valueOf(request.getParameter("id"))).orElse(new Cruise());

        request.setAttribute("cruise",cruise);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/UpdateCruise.jsp");
        requestDispatcher.forward(request,response);
//        cruiseDAO.update(cruise);
//
//        request.getSession().setAttribute("cruise",cruise);
//
//        session.setAttribute("cruise", cruise);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
