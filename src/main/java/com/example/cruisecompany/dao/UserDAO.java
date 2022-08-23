package com.example.cruisecompany.dao;

import com.example.cruisecompany.database.DBCPDataSource;
import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.entity.UserRole;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.example.cruisecompany.database.SQLRequests.*;

public class UserDAO  {

    private UserDAO(){

    }

    private static final UserDAO USER_INSTANCE = new UserDAO();

    public static UserDAO getUserInstance(){
        return USER_INSTANCE;
    }

    private static final DBCPDataSource dataSource = DBCPDataSource.getInstance();

    public void create(User user){

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(CREAT_USER)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4, user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setDouble(7,user.getBalance());

            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Optional<User> read(Long id) {

        User user = null;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(READ_USER)) {

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()) {
                user = new User(id, resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("phone_number"), UserRole.values()[resultSet.getInt("role_id")],
                        " ",resultSet.getString("email"),resultSet.getDouble("balance"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

    public void update(User user) {

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setInt(4,user.getRole().ordinal());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getEmail());
            preparedStatement.setDouble(7,user.getBalance());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void delete(Long id) {

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public boolean register(String phoneNumber, String email){

        boolean ok = false;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DATA_FOR_REGISTER)){

            preparedStatement.setString(1,phoneNumber);
            preparedStatement.setString(2,email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString(1).equals(phoneNumber)){
                    ok = false;
                }else if(resultSet.getString(2).equals(email)){
                    ok = false;
                }
                ok = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return ok;
    }

    public boolean isExistingLogin(String phoneNumber, String email) throws IOException {

        boolean equalsUser;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(USER_DATA_EQUALS)){

            preparedStatement.setString(1,email);
            preparedStatement.setString(2,phoneNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                resultSet.getString(1).equals(email);
                resultSet.getString(2).equals(phoneNumber);
                equalsUser = false;
            }else{
                equalsUser = true;
            }

        } catch (SQLException e) {
            throw new IOException(e);
        }

        return equalsUser;

    }

    public static int addBalance(double balance, Long id, int newBalance){

        int prepared;

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BALANCE)) {

            preparedStatement.setInt(1, (int) (balance + newBalance));
            preparedStatement.setLong(2, id);

            prepared = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return prepared;
    }

}