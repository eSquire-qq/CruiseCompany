package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.service.CatalogueSorting;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Catalog", value = "/Catalog")
public class Catalog extends HttpServlet {

    private static final CatalogueSorting catalogueSorting = CatalogueSorting.getInstance();
    private static final CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("price") != null){
            request.setAttribute("cruise", catalogueSorting.orderByPrice());
        } else if(request.getParameter("name") != null){
            request.setAttribute("cruise", catalogueSorting.orderByName());
        } else if(request.getParameter("date") != null){
            request.setAttribute("cruise", catalogueSorting.orderByDate());
        } else if(request.getParameter("catalog") != null){
            request.setAttribute("cruise", catalogueSorting.clearSort());
        } else{
            request.setAttribute("catalog=catalog", cruiseDAO.readAll());
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/Catalog.jsp");
        requestDispatcher.forward(request,response);
    }

}
