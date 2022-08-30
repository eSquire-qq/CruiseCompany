package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.UserCruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCruise", value = "/DeleteCruise")
public class DeleteCruise extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
        Cruise cruise = new Cruise();

        cruise.setId(id);

        cruiseDAO.delete(id);

        response.sendRedirect("/AdminCatalog");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
