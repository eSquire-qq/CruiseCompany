package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserProfile", value = "/UserProfile")
public class UserProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        UserCruiseDAO userCruiseDao = UserCruiseDAO.getUserCruiseInstance();
        List<UserCruise> userCruiseList = userCruiseDao.showOnProfile(user.getId());

        request.setAttribute("user",user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/Profile.jsp");
        requestDispatcher.forward(request,response);
    }

}
