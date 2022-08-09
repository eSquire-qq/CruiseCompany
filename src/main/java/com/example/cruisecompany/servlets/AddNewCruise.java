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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String duration = request.getParameter("duration");
        String price = request.getParameter("price");
        String cruiseStartDate = request.getParameter("cruiseStartDate");
        String cruiseEndDate = request.getParameter("cruiseEndDate");
        String cruiseLinerName = request.getParameter("cruiseLinerName");
        String passengerCapacity = request.getParameter("passengerCapacity");
        CruiseStatus status = CruiseStatus.REGISTERED;

        Cruise cruise = new Cruise();

        cruise.setDuration(Integer.valueOf(duration));
        cruise.setPrice(Double.valueOf(price));
        cruise.setCruiseStartDate(LocalDate.parse(cruiseStartDate));
        cruise.setCruiseEndDate(LocalDate.parse(cruiseEndDate));
        cruise.setCruiseLinerName(cruiseLinerName);
        cruise.setPassengerCapacity(Integer.valueOf(passengerCapacity));
        cruise.setStatus(status);

    }
}
