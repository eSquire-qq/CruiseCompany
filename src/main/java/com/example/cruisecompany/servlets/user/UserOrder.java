package com.example.cruisecompany.servlets.user;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserOrder", value = "/Order")
public class UserOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        UserCruiseDAO userCruiseDao = UserCruiseDAO.getUserCruiseInstance();
        List<UserCruise> userCruiseList = userCruiseDao.showOnProfile(user.getId());
    }
}
