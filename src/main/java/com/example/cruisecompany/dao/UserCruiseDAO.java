package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.cruisecompany.database.SQLRequests.*;

public class UserCruiseDAO {

    private UserCruiseDAO(){

    }

    private static final UserCruiseDAO USER_CRUISE_INSTANCE = new UserCruiseDAO();

    public static UserCruiseDAO getUserCruiseInstance(){
        return USER_CRUISE_INSTANCE;
    }

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_CRUISE)){

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2,Math.toIntExact(userCruise.getCruise().getId()));
            preparedStatement.setInt(3,Math.toIntExact(userCruise.getUser().getId()));
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public UserCruise read(Integer ticketId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_CRUISE)){

            preparedStatement.setLong(1,ticketId);
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void update(UserCruise userCruise){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_CRUISE)){

            preparedStatement.setInt(1,userCruise.getCabinNumber());
            preparedStatement.setInt(2,Math.toIntExact(userCruise.getCruise().getId()));
            preparedStatement.setInt(3, Math.toIntExact(userCruise.getUser().getId()));
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Integer ticketId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_CRUISE)){

            preparedStatement.setLong(1,ticketId);
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  Cruise addToOrder(Long id){

        Cruise cruise = new Cruise();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CRUISE_ID_TO_ORDER)){

            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cruise.setPrice(resultSet.getDouble("price"));
                cruise.setCruiseStartDate(resultSet.getDate("cruise_start_date"));
                cruise.setCruiseEndDate(resultSet.getDate("cruise_end_date"));
                cruise.setCruiseLinerName(resultSet.getString("cruise_liner_name"));
                cruise.setPassengerCapacity(resultSet.getInt("passenger_capacity"));
                cruise.setDuration(resultSet.getInt("duration"));
                cruise.setCruiseName(resultSet.getString("cruise_name"));
                cruise.setDestination(resultSet.getString("destination"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cruise;
    }

}
