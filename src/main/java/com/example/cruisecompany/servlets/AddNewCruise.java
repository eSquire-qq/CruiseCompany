package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.CruiseDataTime;

import java.io.IOException;

import java.sql.Date;

@WebServlet(name = "AddNewCruise", value = "/AddNewCruise")
public class AddNewCruise extends HttpServlet {

    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/AddCruise.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String duration = request.getParameter("duration");
        String price = request.getParameter("price");
        Date cruiseStartDate = Date.valueOf(request.getParameter("cruiseStartDate"));
        Date cruiseEndDate = Date.valueOf(request.getParameter("cruiseEndDate"));
        String cruiseLinerName = request.getParameter("cruiseLinerName");
        String passengerCapacity = request.getParameter("passengerCapacity");
        CruiseStatus status = CruiseStatus.REGISTERED;
        String cruiseName = request.getParameter("cruiseName");
        String destination = request.getParameter("destination");


        Cruise cruise = new Cruise();

        cruise.setDuration(Integer.valueOf(duration));
        cruise.setPrice(Double.valueOf(price));
        cruise.setCruiseStartDate(cruiseStartDate);
        cruise.setCruiseEndDate(cruiseEndDate);
        cruise.setCruiseLinerName(cruiseLinerName);
        cruise.setPassengerCapacity(Integer.valueOf(passengerCapacity));
        cruise.setStatus(status);
        cruise.setCruiseName(cruiseName);
        cruise.setDestination(destination);

        cruiseDAO.create(cruise);

        response.sendRedirect("/Catalog");

    }
}
