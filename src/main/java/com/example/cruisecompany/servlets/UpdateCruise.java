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

        Long id = Long.valueOf(request.getParameter("id"));

        Cruise cruise = cruiseDAO.read(Long.valueOf(request.getParameter("id"))).orElse(new Cruise());
        request.setAttribute("cruise",cruise);
        request.setAttribute("id",id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/UpdateCruise.jsp");
        requestDispatcher.forward(request,response);
    }

}
