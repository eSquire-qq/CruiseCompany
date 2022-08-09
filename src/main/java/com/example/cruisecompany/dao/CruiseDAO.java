package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

import static com.example.cruisecompany.database.SQLRequests.*;

public class CruiseDAO {

    private CruiseDAO(){

    }

    private static final CruiseDAO CRUISE_INSTANCE = new CruiseDAO();

    public static CruiseDAO getCruiseInstance(){
        return CRUISE_INSTANCE;
    }

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(Cruise cruise){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREAT_CRUISE)){

            preparedStatement.setInt(1,cruise.getDuration());
            preparedStatement.setDouble(2,cruise.getPrice());
            preparedStatement.setDate(3, Date.valueOf(cruise.getCruiseStartDate()));
            preparedStatement.setDate(4, Date.valueOf(cruise.getCruiseEndDate()));
            preparedStatement.setString(5,cruise.getCruiseLinerName());
            preparedStatement.setInt(6,cruise.getPassengerCapacity());
            preparedStatement.setInt(7,cruise.getStatus().ordinal());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<Cruise> read(int id){

        Cruise cruise = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_CRUISE)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(cruise);
    }

    public void update(Cruise cruise){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CRUISE)){

            preparedStatement.setInt(1,cruise.getDuration());
            preparedStatement.setDouble(2,cruise.getPrice());
            preparedStatement.setDate(3, Date.valueOf(cruise.getCruiseStartDate()));
            preparedStatement.setDate(4, Date.valueOf(cruise.getCruiseEndDate()));
            preparedStatement.setString(5,cruise.getCruiseLinerName());
            preparedStatement.setInt(6,cruise.getPassengerCapacity());
            preparedStatement.setInt(7,cruise.getStatus().ordinal());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CRUISE)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
