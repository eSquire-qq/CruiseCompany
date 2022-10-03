package com.example.cruisecompany.service;

import com.example.cruisecompany.dao.CruiseDAO;
import com.example.cruisecompany.entity.Cruise;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class CatalogueSorting {

    private CatalogueSorting(){
    }

    private static final CatalogueSorting CATALOGUE_SORTING_INSTANCE = new CatalogueSorting();

    public static CatalogueSorting getInstance(){
        return CATALOGUE_SORTING_INSTANCE;
    }

    private static final CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

    public static List<Cruise> orderByPrice(HttpServletRequest request){

        List<Cruise> cruisesByPrice;

        if(request.getParameter("price") != null){
            cruisesByPrice = cruiseDAO.readAllOrderByPrice();
        }else{
            cruisesByPrice = cruiseDAO.readAll();
        }
        return cruisesByPrice;
    }

    public static List<Cruise> orderByName(HttpServletRequest request){

        List<Cruise> cruisesByName;

        if(request.getParameter("name") != null){
            cruisesByName = cruiseDAO.readAllOrderByName();
        }else{
            cruisesByName = cruiseDAO.readAll();
        }
        return cruisesByName;
    }

    public static List<Cruise> orderByDate(HttpServletRequest request){

        List<Cruise> cruisesByDate;

        if(request.getParameter("date") != null){
            cruisesByDate = cruiseDAO.readAllOrderByDate();
        }else{
            cruisesByDate = cruiseDAO.readAll();
        }
        return cruisesByDate;
    }

    public static List<Cruise> clearSort(HttpServletRequest request){

        List<Cruise> cruises;

        if(request.getParameter("") != null){
            cruises = cruiseDAO.readAll();
        }else{
            cruises = cruiseDAO.readAll();
        }
        return cruises;
    }
}
