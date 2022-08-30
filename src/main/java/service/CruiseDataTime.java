package service;

import com.example.cruisecompany.entity.Cruise;
import com.example.cruisecompany.entity.CruiseStatus;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static com.example.cruisecompany.database.SQLRequests.*;

public class CruiseDataTime {

    private static final Logger logger = LoggerFactory.getLogger(CruiseDataTime.class);

    private final static BasicDataSource dataSource = new BasicDataSource();

    private CruiseDataTime(){

    }

    private static final CruiseDataTime CRUISE_DATA_TIME_INSTANCE = new CruiseDataTime();

    public static CruiseDataTime getInstance(){
        return CRUISE_DATA_TIME_INSTANCE;
    }

    public boolean equalsTwoDate(Date cruise_end_date)throws IOException  {

        boolean equalsDate = false;
        Date nowDate = new Date();

        try(Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(DATE_VERIFICATION)){

            preparedStatement.setDate(1, (java.sql.Date) cruise_end_date);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                if(resultSet.getDate(1).equals(nowDate)) {
                    Cruise cruise = null;
                    cruise.setStatus(CruiseStatus.COMPLETED);
                }
            }else{
                equalsDate = true;
            }

        } catch (SQLException e) {
            throw new IOException(e);
        }

        return equalsDate;

    }

}
