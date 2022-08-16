package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.cruisecompany.database.SQLRequests.*;

public class UserLoginDAO {

    private UserLoginDAO(){

    }
    private static final Logger logger = LoggerFactory.getLogger(UserLoginDAO.class);

    private static final UserLoginDAO USER_LOGIN_INSTANCE = new UserLoginDAO();

    public static UserLoginDAO getUserLoginInstance(){
        return USER_LOGIN_INSTANCE;
    }

    private static final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public static boolean dataVerification(String phoneNumber, String password) {

        boolean answer = false;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DATA_VERIFICATION)){

            preparedStatement.setString(1,phoneNumber);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString(1).equals(phoneNumber) && resultSet.getString(2).equals(password)){
                    answer = true;
                }
            }

        }catch (SQLException e){
            logger.info("Login correct");
            e.printStackTrace();
        }

        return answer;
    }





}
