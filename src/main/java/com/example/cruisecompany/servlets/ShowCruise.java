package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ShowCruise", value = "/ShowCruise")
public class ShowCruise extends HttpServlet {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
    Cruise cruise = new Cruise();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Cruise> cruises = cruiseDAO.readAll();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowCruise.jsp");
        request.setAttribute("cruises",cruises);
        requestDispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
