package com.example.cruisecompany.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DBCPDataSource.class);

    private final HikariDataSource dataSource;

    private static final DBCPDataSource dbcp;

    static {
        try {
            dbcp = new DBCPDataSource();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.info("Connection successfully");
            return dataSource.getConnection();
        }

    }

    public static DBCPDataSource getInstance(){
        return dbcp;
    }

    private DBCPDataSource() throws ClassNotFoundException {
        HikariConfig config = new HikariConfig("D:\\Java projects\\Repos\\Learn\\CruiseCompany\\src\\main\\resources\\DBConnect.properties");
        dataSource = new HikariDataSource(config);
    }

}
