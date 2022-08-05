package com.example.cruisecompany.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DBCPDataSource.class);

    private final static BasicDataSource dataSource = new BasicDataSource();

    private static final DBCPDataSource dbcp = new DBCPDataSource();

    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.info("Connection successfully", e);
            return dataSource.getConnection();
        }

    }

    public static DBCPDataSource getInstance(){
        return dbcp;
    }

    private DBCPDataSource(){
        dataSource.setUrl("jdbc:postgresql://localhost:5432/CruiseCompany");
        dataSource.setUsername("postgres");
        dataSource.setPassword("eSquire021840984");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

}
