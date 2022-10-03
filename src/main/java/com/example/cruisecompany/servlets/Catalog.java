package com.example.cruisecompany.servlets;

import com.example.cruisecompany.service.CatalogueSorting;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Catalog", value = "/Catalog")
public class Catalog extends HttpServlet {

    private static final CatalogueSorting catalogueSorting = CatalogueSorting.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("cruise", catalogueSorting.orderByPrice(request));
        request.setAttribute("cruise", catalogueSorting.orderByName(request));
        request.setAttribute("cruise", catalogueSorting.orderByDate(request));
        request.setAttribute("cruise", catalogueSorting.clearSort(request));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/Catalog.jsp");
        requestDispatcher.forward(request,response);
    }

}
