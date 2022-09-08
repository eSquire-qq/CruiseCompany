package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
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

    public static User dataVerification(String email, String password) {

        User user = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DATA_VERIFICATION)){

            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
              user = new User();

              user.setId(resultSet.getLong("id"));
              user.setName(resultSet.getString("name"));
              user.setSurname(resultSet.getString("surname"));
              user.setPhoneNumber(resultSet.getString("phone_number"));
              user.setEmail(resultSet.getString("email"));
              user.setBalance(resultSet.getDouble("balance"));

            }

        }catch (SQLException e){
            logger.info("Login correct");
            e.printStackTrace();
        }

        return user;
    }

    public static String userVerification(String email, String password){

        String role = "";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_ADMIN_VERIFICATION)){

            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                role = resultSet.getString("role_id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }

}
