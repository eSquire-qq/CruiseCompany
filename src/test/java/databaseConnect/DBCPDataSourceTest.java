package databaseConnect;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBCPDataSourceTest {

    private final static BasicDataSource dataSource = new BasicDataSource();

    @Test
    void ConnectTest() throws  ClassNotFoundException, SQLException {

        dataSource.setUrl("jdbc:postgresql://localhost:5432/ANDRIY");
        dataSource.setUsername("postgres");
        dataSource.setPassword("eSquire021840984");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);

    }

}
