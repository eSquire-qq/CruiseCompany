package com.example.cruisecompany.database;

public class SQLRequests {

    private SQLRequests(){

    }

    public static final String CREAT_USER = "INSERT INTO \"user\" (name, surname, phone_number, role_id, password, email) VALUES (?,?,?,?,?,?)";
    public static final String READ_USER = "SELECT name, surname, phone_number, role_id, email, FROM \"user\" WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE \"user\" SET name = ?, surname = ?, phone_number = ?, role_id = ?, password = ?, email = ? WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM \"user\" WHERE id = ?";


    public static final String CREAT_CRUISE = "INSERT INTO \"cruise\" (duration, price, cruise_start_date, cruise_end_date, cruise_liner_name,passenger_capacity,status, cruise_name, destination) VALUES (?,?,?::date,?::date,?,?,?,?,?)";
    public static final String READ_CRUISE = "SELECT duration, price, cruise_start_date, cruise_end_date, cruise_liner_name,passenger_capacity,status, destination FROM \"cruise\" WHERE id = ?";
    public static final String UPDATE_CRUISE = "UPDATE \"cruise\" SET duration = ?, price = ?, cruise_start_date = ?, cruise_end_date = ?, cruise_liner_name = ?, passenger_capacity = ?,status = ?, cruise_name = ?, destination = ? WHERE id = ? ";
    public static final String DELETE_CRUISE = "DELETE FROM \"cruise\" WHERE id = ?";
    public static final String READ_ALL_CRUISE = "SELECT * FROM \"cruise\"";

    public static final String SHOW_CRUISE_INFORMATION = "SELECT * FROM \"cruises\"";


    public static final String CREATE_USER_CRUISE = "INSERT INTO \"user_cruise\" (ticket_id, cabinNumber, cruise_id, user_id, status_id ) VALUES (?,?,?,?,?)";
    public static final String READ_USER_CRUISE = "SELECT cabinNumber, cruise_id, user_id, status_id FROM \"user_cruise\" WHERE ticket_id = ?";
    public static final String UPDATE_USER_CRUISE = "UPDATE \"user_cruise\" SET cabin_number = ?, cruise_id = ?, user_id = ?, status_id = ? WHERE ticket_id = ?";
    public static final String DELETE_USER_CRUISE = "DELETE FROM \"user_cruise\" WHERE ticket_id = ?";


    public static final String CREATE_ADMIN = "INSERT INTO \"user\" (name, surname, phone_number, role_id, password, email) VALUES (?,?,?,?,?,?)";
    public static final String READ_ADMIN = "SELECT name, surname, phone_number, role_id FROM \"user\" WHERE id = ?";
    public static final String UPDATE_ADMIN = "UPDATE \"user\" SET name = ?, surname = ?, phone_number = ?, role_id = ?, password = ?, email = ? WHERE passenger_id = ?";
    public static final String DELETE_ADMIN = "DELETE FROM \"user\" WHERE id = ?";


    public static final String DATA_VERIFICATION = "SELECT * FROM \"user\" WHERE phone_number = ? AND password = ? ";

    public static final String USER_DATA_EQUALS = "SELECT email, phone_number FROM \"user\" WHERE email = ? AND phone_number = ?";

    public static final String DATA_FOR_REGISTER = "SELECT * FROM \"user\" WHERE phone_number = ?, password = ?";



}
