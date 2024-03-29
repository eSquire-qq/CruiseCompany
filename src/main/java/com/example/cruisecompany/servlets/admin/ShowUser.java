package com.example.cruisecompany.servlets.admin;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ShowUser", value = "/ShowUser")
public class ShowUser extends HttpServlet {

    UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/ShowUser.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(Integer.valueOf(request.getParameter("id")));
        Optional<User> user = userDAO.read(id);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user",user.get());

        response.sendRedirect( request.getContextPath() + "/ShowUser.jsp");

    }
}
