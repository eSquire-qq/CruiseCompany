package com.example.cruisecompany.database;

public class SQLRequests {

    private SQLRequests(){

    }

    public static final String CREAT_USER = "INSERT INTO \"user\" (name, surname, phone_number, role_id, password, email) VALUES (?,?,?,?,?,?)";
    public static final String READ_USER = "SELECT name, surname, phone_number, role_id, email, balance FROM \"user\" WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE \"user\" SET name = ?, surname = ?, phone_number = ?, role_id = ?, password = ?, email = ? WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM \"user\" WHERE id = ?";

    public static final String ADD_BALANCE = "UPDATE \"user\" SET balance = ? WHERE id = ?";

    public static final String CREAT_CRUISE = "INSERT INTO \"cruise\" (price, cruise_start_date, cruise_end_date, cruise_liner_name, passenger_capacity, status, cruise_name, destination, departure) VALUES (?,?::date,?::date,?,?,?,?,?,?)";
    public static final String READ_CRUISE = "SELECT id, cruise_name, price, cruise_start_date, cruise_end_date, cruise_liner_name,passenger_capacity,status, destination, departure FROM \"cruise\" WHERE id = ?";
    public static final String UPDATE_CRUISE = "UPDATE \"cruise\" SET price = ?, cruise_start_date = ?, cruise_end_date = ?, cruise_liner_name = ?, passenger_capacity = ?,status = ?, cruise_name = ?, destination = ?, departure = ? WHERE id = ? ";
    public static final String DELETE_CRUISE = "DELETE FROM \"cruise\" WHERE id = ?";
    public static final String READ_ALL_CRUISE = "SELECT * FROM \"cruise\" WHERE status = 0 AND cruise_end_date >= current_date";
    public static final String READ_ALL_CRUISE_FOR_ADMIN = "SELECT * FROM \"cruise\" WHERE status = 0";

    public static final String READ_CRUISE_BY_PRICE = "SELECT * FROM \"cruise\" WHERE status = 0 ORDER BY price DESC";
    public static final String READ_CRUISE_BY_NAME = "SELECT * FROM \"cruise\" WHERE status = 0 ORDER BY cruise_name DESC";
    public static final String READ_CRUISE_BY_DATE = "SELECT * FROM \"cruise\" WHERE status = 0 ORDER BY cruise_start_date DESC";

    public static final String SHOW_ONE_CRUISE = "SELECT * FROM \"cruise\" WHERE id = ?";


    public static final String CREATE_USER_CRUISE = "INSERT INTO \"user_cruise\" (cruise_id, user_id, status_id,name_of_cruise, cruise_start_date, cruise_end_date) VALUES (?,?,?,?,?,?)";
    public static final String READ_USER_CRUISE = "SELECT cabinNumber, cruise_id, user_id, status_id FROM \"user_cruise\" WHERE ticket_id = ?";
    public static final String UPDATE_USER_CRUISE = "UPDATE \"user_cruise\" SET cabin_number = ?, cruise_id = ?, user_id = ?, status_id = ? WHERE ticket_id = ?";
    public static final String DELETE_USER_CRUISE = "DELETE FROM \"user_cruise\" WHERE ticket_id = ?";


    public static final String CREATE_ADMIN = "INSERT INTO \"user\" (name, surname, phone_number, role_id, password, email) VALUES (?,?,?,?,?,?)";
    public static final String READ_ADMIN = "SELECT name, surname, phone_number, role_id FROM \"user\" WHERE id = ?";
    public static final String UPDATE_ADMIN = "UPDATE \"user\" SET name = ?, surname = ?, phone_number = ?, role_id = ?, password = ?, email = ? WHERE passenger_id = ?";
    public static final String DELETE_ADMIN = "DELETE FROM \"user\" WHERE id = ?";


    public static final String DATA_VERIFICATION = "SELECT * FROM \"user\" WHERE email = ? AND password = ? ";
    public static final String USER_ADMIN_VERIFICATION = "SELECT role_id FROM  \"user\" WHERE email = ? AND password = ? ";
    public static final String USER_PHONE_EQUALS = "SELECT phone_number FROM \"user\" WHERE phone_number = ? ";
    public static final String USER_EMAIL_EQUALS = "SELECT email FROM \"user\" WHERE email = ? ";
    public static final String DATA_FOR_REGISTER = "SELECT * FROM \"user\" WHERE phone_number = ?, password = ?";
    public static final String DATE_VERIFICATION = "SELECT cruise_end_date FROM \"cruise\" where cruise_end_date = ? ";
    public static final String DATE_UPDATE = "UPDATE \"cruise\" SET cruise_end_date = ?";

    public static final String ADD_TO_ORDER = "INSERT INTO \"user_cruise\" () VALUE";
    public static final String ADD_CRUISE_ID_TO_ORDER = "SELECT * FROM \"cruise\" WHERE id = ?";

    public static final String SHOW_ON_PROFILE =  "SELECT * FROM \"user_cruise\" WHERE user_id = ?";
    public static final String SHOW_USERS_ORDERS =  "SELECT * FROM \"user_cruise\"";

    public static final String CONFIRM_USER_ORDER = "UPDATE \"user_cruise\" SET status_id = ? WHERE ticket_id = ?";
    public static final String REFUTE_USER_ORDER = "UPDATE \"user_cruise\" SET status_id = ? WHERE ticket_id = ?";
    public static final String PAID_USER_ORDER = "UPDATE \"user_cruise\" SET status_id = ? WHERE ticket_id = ?";

    public static final String PAY_ORDER = "UPDATE \"user\" SET balance = balance - ? WHERE id = ? ";
    public static final String UPLOAD_USERS_DOCUMENTS = "UPDATE \"user_cruise\" SET document = ? WHERE ticket_id = ?";

}
