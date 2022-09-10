package com.example.cruisecompany.servlets.user;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Payments", value = "/Payments")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Payments extends HttpServlet {

    private static CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    private static UserCruiseDAO userCruiseDAO = UserCruiseDAO.getUserCruiseInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Integer ticketId = Integer.valueOf(request.getParameter("ticketId"));

        Cruise cruise = cruiseDAO.readOneCruise(id);
        UserCruiseDAO.getUserCruiseInstance().activeUserOrder(ticketId);

        request.setAttribute("cruisePrice",cruise.getPrice());
        request.setAttribute("ticketId",ticketId);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/Payments.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        Integer ticketId = Integer.valueOf(request.getParameter("ticketId"));
        Double cruisePrice = Double.valueOf(request.getParameter("cruisePrice"));

        Part file = request.getPart("file");
        String fileName = file.getSubmittedFileName();

        for (Part part : request.getParts()) {
            part.write("documents\\" + fileName);
        }

        userCruiseDAO.updateDocument(fileName,ticketId);

        UserCruiseDAO.getUserCruiseInstance().changeBalance(cruisePrice,user.getId());
        user.setBalance(user.getBalance()-cruisePrice);
        response.sendRedirect("/UserProfile");
    }
}
