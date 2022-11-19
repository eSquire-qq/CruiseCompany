package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;
import com.example.cruisecompany.entity.UserCruise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

            preparedStatement.setLong(1,userCruise.getCruiseId());
            preparedStatement.setLong(2,userCruise.getUserId());
            preparedStatement.setInt(3, CruiseStatus.REGISTERED.ordinal());
            preparedStatement.setString(4, userCruise.getNameOfCruise());
            preparedStatement.setDate(5, (Date) userCruise.getCruiseStartDate());
            preparedStatement.setDate(6, (Date) userCruise.getCruiseEndDate());

            preparedStatement.executeQuery();

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
            preparedStatement.setLong(2,userCruise.getCruiseId());
            preparedStatement.setLong(3,userCruise.getUserId());
            preparedStatement.setInt(4,userCruise.getStatusId());

            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Long ticketId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_CRUISE)){

            preparedStatement.setLong(1,ticketId);
            preparedStatement.executeUpdate();

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

                cruise.setId(resultSet.getLong("id"));

                cruise.setPrice(resultSet.getDouble("price"));
                cruise.setCruiseStartDate(resultSet.getDate("cruise_start_date"));
                cruise.setCruiseEndDate(resultSet.getDate("cruise_end_date"));
                cruise.setCruiseLinerName(resultSet.getString("cruise_liner_name"));
                cruise.setPassengerCapacity(resultSet.getInt("passenger_capacity"));
                cruise.setCruiseName(resultSet.getString("cruise_name"));
                cruise.setDestination(resultSet.getString("destination"));
                cruise.setDestination(resultSet.getString("cruise_name"));
                cruise.setCruiseStartDate(resultSet.getDate("cruise_start_date"));
                cruise.setCruiseStartDate(resultSet.getDate("cruise_end_date"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cruise;
    }

    public List<UserCruise> showOnProfile(Long id){
        List<UserCruise> userCruiseList = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ON_PROFILE)){

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                userCruiseList.add(new UserCruise(resultSet.getLong("ticket_id"), resultSet.getInt("cabin_number"),
                        resultSet.getLong("cruise_id"), resultSet.getLong("user_id"), resultSet.getInt("status_id"),
                        resultSet.getString("name_of_cruise"),resultSet.getDate("cruise_start_date"),
                        resultSet.getDate("cruise_end_date"), resultSet.getString("document")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return userCruiseList;
    }

    public List<UserCruise> showOrderForAdmin(){
        List<UserCruise> userOrders = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_USERS_ORDERS)){

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                userOrders.add(new UserCruise(resultSet.getLong("ticket_id"), resultSet.getInt("cabin_number"),
                        resultSet.getLong("cruise_id"), resultSet.getLong("user_id"), resultSet.getInt("status_id"),
                        resultSet.getString("name_of_cruise"),resultSet.getDate("cruise_start_date"),
                        resultSet.getDate("cruise_end_date"),resultSet.getString("document")));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return userOrders;
    }

    public void confirmUserOrder(Long id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CONFIRM_USER_ORDER)){

            preparedStatement.setInt(1,CruiseStatus.CONFIRM.ordinal());
            preparedStatement.setLong(2,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void refuteUserOrder(Long id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REFUTE_USER_ORDER)){

            preparedStatement.setInt(1,CruiseStatus.CANCELED.ordinal());
            preparedStatement.setLong(2,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void activeUserOrder(Integer id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PAID_USER_ORDER)){

            preparedStatement.setInt(1,CruiseStatus.PAID.ordinal());
            preparedStatement.setLong(2,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void changeBalance(Double price,Long id){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PAY_ORDER)){

            preparedStatement.setDouble(1,price);
            preparedStatement.setLong(2,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDocument(String fileName,Integer ticketId){
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPLOAD_USERS_DOCUMENTS)){

            preparedStatement.setString(1,fileName);
            preparedStatement.setInt(2,ticketId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
