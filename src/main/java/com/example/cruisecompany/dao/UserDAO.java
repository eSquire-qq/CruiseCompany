package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.example.cruisecompany.dao.SQLRequests.*;

public class UserDAO  {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(CREAT_USER);

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRoleId().ordinal());

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<User> read(Long id){

        User user = null;

        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER);

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {

                user = new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("phone_number"), UserRole.USER);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    public void update(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
