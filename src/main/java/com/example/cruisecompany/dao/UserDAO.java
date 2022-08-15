package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.example.cruisecompany.database.SQLRequests.*;

public class UserDAO  {

    private UserDAO(){

    }

    private static final UserDAO USER_INSTANCE = new UserDAO();

    public static UserDAO getUserInstance(){
        return USER_INSTANCE;
    }

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(User user){

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(CREAT_USER)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4, user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());

            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<User> read(Long id) {

        User user = null;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER)) {

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                user = new User(id, resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("phone_number"), UserRole.values()[resultSet.getInt("role_id")], " ",resultSet.getString("email"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    public void update(User user) {

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Long id) {

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

