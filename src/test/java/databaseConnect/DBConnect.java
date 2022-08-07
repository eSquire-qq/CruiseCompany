package databaseConnect;

import com.example.cruisecompany.database.DBCPDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {

    private static final Logger logger = LoggerFactory.getLogger(DBConnect.class);

    private final static BasicDataSource dataSource = new BasicDataSource();

    private static final DBConnect dbcp = new DBConnect();

    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.info("Connection successfully", e);
            return dataSource.getConnection();
        }

    }

    public static DBConnect getInstance(){
        return dbcp;
    }

    private DBConnect(){
        dataSource.setUrl("jdbc:postgresql://localhost:5432/ANDRIY");
        dataSource.setUsername("postgres");
        dataSource.setPassword("e12323");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

}
