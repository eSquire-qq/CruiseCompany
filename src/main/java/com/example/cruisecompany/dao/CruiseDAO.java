package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class CruiseDAO {

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(Cruise cruise){
        try(Connection connection = dataSource.getConnection();){

            PreparedStatement preparedStatement = connection.prepareStatement(" INSERT INTO \"cruise\" (duration, price, cruise_start_date, cruise_end_date, cruise_liner_name,passenger_capacity,status)" +
                                                                                 " VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setTime(1, (Time) cruise.getCruiseStartDate());
            preparedStatement.setTime(1, (Time) cruise.getCruiseEndDate());


            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public UserCruise read(int cruise_id){
        try(Connection connection = dataSource.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO \"cruise\" (duration, price, cruise_start_date, cruise_end_date, cruise_liner_name,passenger_capacity,status) WHERE cruise_id = ?");

            preparedStatement.setLong(1,cruise_id);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }


}
