package com.example.cruisecompany;

import com.example.cruisecompany.dao.AdminDAO;
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

import static com.example.cruisecompany.entity.UserRole.ADMINISTRATOR;
import static com.example.cruisecompany.entity.UserRole.MANAGER;


public class Main {
    public static void main(final String[] args) throws ClassNotFoundException {

        AdminDAO adminDAO = AdminDAO.getAdminInstance();

        adminDAO.create(new User(20L,"name1", "surname1", "phoneNumber1", ADMINISTRATOR, "password1", "email1"));

    }
}

