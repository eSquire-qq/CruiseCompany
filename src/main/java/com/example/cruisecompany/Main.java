package com.example.cruisecompany;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    public static void main(final String[] args)
    {

        UserDAO userDAO = new UserDAO();
        UserCruiseDAO userCruiseDAO = new UserCruiseDAO();

        //userDAO.create(new User("Andriy","Kolosovskiy","6845887",1,1L));
        //userDAO.read(6L);

//        userCruiseDAO.create(new UserCruise(1L,1,new Cruise(1L),new User(),1));
//        userCruiseDAO.read(3);

    }
}

