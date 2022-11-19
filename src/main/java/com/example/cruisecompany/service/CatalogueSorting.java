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

    public static List<Cruise> orderByPrice(){

        List<Cruise> cruisesByPrice;
        cruisesByPrice = cruiseDAO.readAllOrderByPrice();

        return cruisesByPrice;
    }

    public static List<Cruise> orderByName(){

        List<Cruise> cruisesByName;
        cruisesByName = cruiseDAO.readAllOrderByName();

        return cruisesByName;
    }

    public static List<Cruise> orderByDate(){

        List<Cruise> cruisesByDate;
        cruisesByDate = cruiseDAO.readAllOrderByDate();

        return cruisesByDate;
    }

    public static List<Cruise> clearSort(){

        List<Cruise> cruises;
        cruises = cruiseDAO.readAll();

        return cruises;
    }
}
