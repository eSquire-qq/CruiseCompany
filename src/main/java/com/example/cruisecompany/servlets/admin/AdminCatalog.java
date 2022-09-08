package com.example.cruisecompany.servlets.admin;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCatalog", value = "/AdminCatalog")
public class AdminCatalog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();
        List<Cruise> cruises = cruiseDAO.readAllForAdmin();
        request.getSession().setAttribute("cruises",cruises);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/AdminCatalog.jsp");
        requestDispatcher.forward(request,response);
    }
}
