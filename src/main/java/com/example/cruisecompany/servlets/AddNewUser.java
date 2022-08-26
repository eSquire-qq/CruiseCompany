package com.example.cruisecompany.servlets;

import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.example.cruisecompany.entity.User;

import static service.PasswordHashCode.hashPassword;

@WebServlet(name = "AddNewUser", value = "/AddNewUser")
public class AddNewUser extends HttpServlet {

     UserDAO userDAO = UserDAO.getUserInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/add/AddUser.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        UserRole role = UserRole.USER;
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Double balance = Double.valueOf(request.getParameter("balance"));

        if(UserDAO.getUserInstance().isExistingLogin(phoneNumber,email)) {

            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setPhoneNumber(phoneNumber);
            user.setRole(role);
            user.setPassword(hashPassword(password));
            user.setEmail(email);
            user.setBalance(balance);

            userDAO.create(user);

            request.getSession().setAttribute("user",user);
            response.sendRedirect("/LoginUser");

        }
        else{
            response.sendRedirect("AddNewUser");
        }

    }
}
