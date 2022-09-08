package com.example.cruisecompany.filtres;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoginUserFilter", urlPatterns = {"/UserProfile/*","/Booking/*"})
public class LoginUserFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession httpSession = httpServletRequest.getSession();

        if(httpSession.getAttribute("user") == null){
            httpServletResponse.sendRedirect("LoginUser");
        }
        else{
            chain.doFilter(httpServletRequest, httpServletResponse);
        }

    }
}
