package DataBase;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource { // Connection connection = DBCPDataSource.getConnection();

    private final static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:postgresql://localhost:5432/CruiseCompany");
        dataSource.setUsername("postgres");
        dataSource.setPassword("eSquire021840984");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private DBCPDataSource(){ }
}
