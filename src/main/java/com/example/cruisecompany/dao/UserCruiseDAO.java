package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.cruisecompany.dao.SQLRequests.*;

public class UserCruiseDAO {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USERCRUISE);

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2,Math.toIntExact(userCruise.getCruise().getId()));
            preparedStatement.setInt(3, Math.toIntExact(userCruise.getUser().getId()));
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public UserCruise read(Integer ticket_id ){
        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement(READ_USERCRUISE);

            preparedStatement.setLong(1,ticket_id);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void update(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERCRUISE);

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2,Math.toIntExact(userCruise.getCruise().getId()));
            preparedStatement.setInt(3, Math.toIntExact(userCruise.getUser().getId()));
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERCRUISE);

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
