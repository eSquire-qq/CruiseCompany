package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.cruisecompany.database.SQLRequests.CREAT_USER;
import static com.example.cruisecompany.database.SQLRequests.DATA_VERIFICATION;

public class UserLoginDAO {

    private UserLoginDAO(){

    }
    private static final Logger logger = LoggerFactory.getLogger(UserLoginDAO.class);

    private static final UserLoginDAO USER_LOGIN_INSTANCE = new UserLoginDAO();

    public static UserLoginDAO getUserLoginInstance(){
        return USER_LOGIN_INSTANCE;
    }

    private static final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public static boolean DataVerification(String phoneNumber, String password) throws ClassNotFoundException {

        boolean answer = false;

        Class.forName("org.postgresql.Driver");

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DATA_VERIFICATION)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString(1).equals(phoneNumber) && resultSet.getString(2).equals(password)){
                    answer = true;
                }
            }

        }catch (SQLException e){
            logger.error(e.getMessage());
        }
        return answer;
    }

}
