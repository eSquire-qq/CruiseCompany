package com.example.cruisecompany;

import com.example.cruisecompany.dao.*;
import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import com.example.cruisecompany.entity.UserRole;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

import java.sql.Connection;

import static com.example.cruisecompany.entity.CruiseStatus.*;

public class Main {
    public static void main(final String[] args) throws ClassNotFoundException {

        //AdminDAO adminDAO = AdminDAO.getAdminInstance();
        CruiseDAO cruiseDAO = CruiseDAO.getCruiseInstance();

        //cruiseDAO.read(new Cruise(10L, 100.000, java.time.LocalDate.now(), java.time.LocalDate.now(),"Viking", 800,REGISTERED, 100));

        //adminDAO.create(new User(20L,"name1", "surname1", "phoneNumber1", ADMINISTRATOR, "password1", "email1"));

    }
}

