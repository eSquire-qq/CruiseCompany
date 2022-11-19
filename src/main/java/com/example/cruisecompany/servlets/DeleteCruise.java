package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCruise", value = "/DeleteCruise")
public class DeleteCruise extends HttpServlet {

    private final CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        cruiseDAO.delete(id);
        response.sendRedirect("/AdminCatalog");
    }
}
