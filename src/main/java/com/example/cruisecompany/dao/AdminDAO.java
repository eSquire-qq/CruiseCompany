package com.example.cruisecompany.dao;

import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.example.cruisecompany.database.SQLRequests.*;

public class AdminDAO {

    private AdminDAO(){

    }

    private static final AdminDAO ADMIN_INSTANCE = new AdminDAO();

    public static AdminDAO getAdminInstance(){
        return ADMIN_INSTANCE;
    }

    private final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(User user){

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ADMIN)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4, user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());

            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<User> read(Long id) {

        User user = null;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(READ_ADMIN)) {

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {

                user = new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("phone_number"), UserRole.values()[resultSet.getInt("role_id")],
                        resultSet.getString("password"),resultSet.getString("e-mail"),resultSet.getDouble("balance"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    public void update(User user){

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setInt(7,0);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Long id){

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADMIN)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
