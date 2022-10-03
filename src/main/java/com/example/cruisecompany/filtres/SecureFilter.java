package com.example.cruisecompany.filtres;

import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "SecureFilter")
public class SecureFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession httpSession = httpServletRequest.getSession();

        User admin = (User) httpSession.getAttribute("admin");

        if(admin.getRole() != UserRole.ADMINISTRATOR){
            httpServletResponse.sendRedirect("/404.html");
        }else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
