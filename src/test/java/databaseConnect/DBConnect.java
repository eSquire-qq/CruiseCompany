package databaseConnect;

import com.example.cruisecompany.database.DBCPDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {

    private static final Logger logger = LoggerFactory.getLogger(DBConnect.class);

    private final static BasicDataSource dataSourceTest = new BasicDataSource();

    private static final DBConnect dbcp = new DBConnect();


    private String url ;
    private String username ;
    private String password  ;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        try {
            return dataSourceTest.getConnection();
        } catch (SQLException e) {
            logger.info("Connection successfully", e);
            return dataSourceTest.getConnection();
        }

    }

    public static DBConnect getInstance(){
        return dbcp;
    }

    private DBConnect(){
        dataSourceTest.setUrl(url);
        dataSourceTest.setUsername(username);
        dataSourceTest.setPassword(password);
        dataSourceTest.setMinIdle(5);
        dataSourceTest.setMaxIdle(10);
        dataSourceTest.setMaxOpenPreparedStatements(100);
    }

}
