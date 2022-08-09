package databaseConnect;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBCPDataSourceTest {

    private static final DBConnect dbcp = DBConnect.getInstance();

    private static final Logger logger = LoggerFactory.getLogger(DBCPDataSourceTest.class);

    @Test
    void testIncorrectConnect() {
        dbcp.setUrl("jdbc:postgresql://localhost:5432/TestCruiseCompany123123");
        dbcp.setUsername("postgres");
        dbcp.setPassword("eSquire021840984123123");

        try {
            assertThrows(SQLException.class, (Executable) dbcp.getConnection());
        }catch (SQLException e) {
            logger.error("Cannot get connect");
        }
    }

    @Test
    void testSimpleConnect() {
        dbcp.setUrl("jdbc:postgresql://localhost:5432/TestCruiseCompany");
        dbcp.setUsername("postgres");
        dbcp.setPassword("eSquire021840984");
        try {
            assertDoesNotThrow((Executable) dbcp.getConnection());
        } catch (SQLException e) {
            logger.error("Cannot get connection");
        }
    }

}
