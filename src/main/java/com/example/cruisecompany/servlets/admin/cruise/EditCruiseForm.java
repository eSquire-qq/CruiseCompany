package com.example.cruisecompany.servlets.admin.cruise;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EditCruiseForm", value = "/EditCruiseForm")
public class EditCruiseForm extends HttpServlet {

    CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/UpdateCruise.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));
        String price = request.getParameter("price");
        Date cruiseStartDate = Date.valueOf(request.getParameter("cruiseStartDate"));
        Date cruiseEndDate = Date.valueOf(request.getParameter("cruiseEndDate"));
        String cruiseLinerName = request.getParameter("cruiseLinerName");
        String passengerCapacity = request.getParameter("passengerCapacity");
        CruiseStatus status = CruiseStatus.REGISTERED;
        String cruiseName = request.getParameter("cruiseName");
        String destination = request.getParameter("destination");
        String departure = request.getParameter("departure");

        Cruise cruise = new Cruise();

        cruise.setPrice(Double.valueOf(price));
        cruise.setCruiseStartDate(cruiseStartDate);
        cruise.setCruiseEndDate(cruiseEndDate);
        cruise.setCruiseLinerName(cruiseLinerName);
        cruise.setStatus(status);
        cruise.setPassengerCapacity(Integer.valueOf(passengerCapacity));
        cruise.setCruiseName(cruiseName);
        cruise.setDestination(destination);
        cruise.setDeparture(departure);

        cruiseDAO.update(cruise,id);

        response.sendRedirect("/AdminCatalog");

    }
}
