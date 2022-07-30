package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Optional;

import static com.example.cruisecompany.dao.SQLRequests.*;

public class CruiseDAO {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(Cruise cruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(READ_CRUISE);

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<Cruise> read(int id){

        Cruise cruise = null;

        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement(READ_CRUISE);

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(cruise);
    }

    public void update(Cruise cruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CRUISE);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Cruise cruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CRUISE);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
