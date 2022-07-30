package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCruiseDAO {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"user_cruise\" (cabin_number, cruise_id, user_id, status_id) VALUES (?,?,?,?)");

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2, Math.toIntExact(userCruise.getCruise().getCruiseId()));
            preparedStatement.setInt(3,userCruise.getUser().getRoleId());
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public UserCruise read(Integer ticket_id ){
        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cabin_number, cruise_id, user_id, status_id FROM \"user_cruise\" WHERE ticket_id = ?");

            preparedStatement.setLong(1,ticket_id);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void update(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE \"user_cruise\" SET cabin_number = ?, cruise_id = ?, user_id = ?, status_id = ? WHERE ticket_id = ?");

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2, Math.toIntExact(userCruise.getCruise().getCruiseId()));
            preparedStatement.setInt(3,userCruise.getUser().getRoleId());
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"user_cruise\" WHERE ticket_id = ?");

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
