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

        List<Cruise> cruisesByPrice;

        if(request.getParameter("name") != null){
            cruisesByPrice = cruiseDAO.readAllOrderByName();
        }else{
            cruisesByPrice = cruiseDAO.readAll();
        }
        return cruisesByPrice;
    }

    public static List<Cruise> orderByDate(HttpServletRequest request){

        List<Cruise> cruisesByPrice;

        if(request.getParameter("date") != null){
            cruisesByPrice = cruiseDAO.readAllOrderByDate();
        }else{
            cruisesByPrice = cruiseDAO.readAll();
        }
        return cruisesByPrice;
    }

}
