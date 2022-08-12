package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "AddNewCruise", value = "/AddNewCruise")
public class AddNewCruise extends HttpServlet {

    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/HomePage.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String price = request.getParameter("price");
        String cruiseStartDate = request.getParameter("cruiseStartDate");
        String cruiseEndDate = request.getParameter("cruiseEndDate");
        String cruiseLinerName = request.getParameter("cruiseLinerName");
        String passengerCapacity = request.getParameter("passengerCapacity");
        CruiseStatus status = CruiseStatus.REGISTERED;
        String duration = request.getParameter("duration");
        String cruiseName = request.getParameter("cruiseName");

        Cruise cruise = new Cruise();

        cruise.setPrice(Double.valueOf(price));
        cruise.setCruiseStartDate(LocalDate.parse(cruiseStartDate));
        cruise.setCruiseEndDate(LocalDate.parse(cruiseEndDate));
        cruise.setCruiseLinerName(cruiseLinerName);
        cruise.setPassengerCapacity(Integer.valueOf(passengerCapacity));
        cruise.setStatus(status);
        cruise.setDuration(Integer.valueOf(duration));
        cruise.setCruiseName(cruiseName);

        cruiseDAO.create(cruise);

    }
}
