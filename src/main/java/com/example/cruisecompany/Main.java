package com.example.cruisecompany;

import com.example.cruisecompany.dao.UserCruiseDAO;
import com.example.cruisecompany.dao.UserDAO;
import com.example.cruisecompany.dao.UserLoginDAO;
import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;
import com.example.cruisecompany.entity.UserRole;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;


public class Main {
    public static void main(final String[] args) throws ClassNotFoundException {

        System.out.println(UserLoginDAO.getUserLoginInstance().DataVerification("56845671","password"));

    }
}

