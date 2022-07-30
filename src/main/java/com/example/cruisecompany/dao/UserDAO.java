package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAO  {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user\" (name, surname, phone_number, role_id) VALUES (?,?,?,?)");

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRoleId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<User> read(Long id){

        User user = null;

        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, surname, phone_number, role_id FROM \"user\" WHERE id = ?");

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {

                //user = new User(resultSet.getLong("id"),resultSet.);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    public void update(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE \"user\" SET name = ?, surname = ?, phone_number = ?, role_id = ? WHERE passenger_id = ?");

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRoleId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(User user){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"user\" WHERE id = ?");

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
