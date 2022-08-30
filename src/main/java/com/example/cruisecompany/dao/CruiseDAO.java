package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            preparedStatement.setDate(3, (Date) cruise.getCruiseStartDate());
            preparedStatement.setDate(4, (Date) cruise.getCruiseEndDate());
            preparedStatement.setString(5,cruise.getCruiseLinerName());
            preparedStatement.setInt(6,cruise.getPassengerCapacity());
            preparedStatement.setInt(7,cruise.getStatus().ordinal());
            preparedStatement.setString(8,cruise.getCruiseName());
            preparedStatement.setString(9,cruise.getDestination());

            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<Cruise> read(Long id){

        Cruise cruise = null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_CRUISE)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                cruise = new Cruise(resultSet.getLong("id"),resultSet.getDouble("price"),resultSet.getDate("cruise_start_date"),
                        resultSet.getDate("cruise_end_date"),resultSet.getString("cruise_liner_name"),
                        resultSet.getInt("passenger_capacity"), CruiseStatus.values()[resultSet.getInt("status")],
                        resultSet.getInt("duration"),resultSet.getString("cruise_name"),resultSet.getString("destination"));
            }

            }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(cruise);
    }

    public List<Cruise> readAll(){
        List<Cruise> cruiseList = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_CRUISE)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                cruiseList.add(new Cruise(resultSet.getLong("id"),resultSet.getDouble("price"),resultSet.getDate("cruise_start_date"),
                        resultSet.getDate("cruise_end_date"),resultSet.getString("cruise_liner_name"),
                        resultSet.getInt("passenger_capacity"), CruiseStatus.values()[resultSet.getInt("status")],
                        resultSet.getInt("duration"),resultSet.getString("cruise_name"),resultSet.getString("destination")));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return cruiseList;
    }

    public List<Cruise> readAllForAdmin(){
        List<Cruise> cruiseList = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_CRUISE_FOR_ADMIN)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                cruiseList.add(new Cruise(resultSet.getLong("id"),resultSet.getDouble("price"),resultSet.getDate("cruise_start_date"),
                        resultSet.getDate("cruise_end_date"),resultSet.getString("cruise_liner_name"),
                        resultSet.getInt("passenger_capacity"), CruiseStatus.values()[resultSet.getInt("status")],
                        resultSet.getInt("duration"),resultSet.getString("cruise_name"),resultSet.getString("destination")));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return cruiseList;
    }

    public void update(Cruise cruise){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CRUISE)){

            preparedStatement.setInt(1,cruise.getDuration());
            preparedStatement.setDouble(2,cruise.getPrice());
            preparedStatement.setDate(3, (Date) cruise.getCruiseStartDate());
            preparedStatement.setDate(4, (Date) cruise.getCruiseEndDate());
            preparedStatement.setString(5,cruise.getCruiseLinerName());
            preparedStatement.setInt(6,cruise.getPassengerCapacity());
            preparedStatement.setInt(7,cruise.getStatus().ordinal());
            preparedStatement.setString(8,cruise.getCruiseName());
            preparedStatement.setString(9,cruise.getDestination());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Long id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CRUISE)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
