package DataBase.Entity;

import java.util.Date;

public class Cruise {

    private Long CruiseID;
    private Integer Duration;
    private Integer Price;
    private Date CruiseStartDate;
    private Date CruiseEndDate;
    private String CruiseLinerName;

    public Cruise(Long cruiseID, Integer duration, Integer price, Date cruiseStartDate, Date cruiseEndDate, String cruiseLinerName) {
        CruiseID = cruiseID;
        Duration = duration;
        Price = price;
        CruiseStartDate = cruiseStartDate;
        CruiseEndDate = cruiseEndDate;
        CruiseLinerName = cruiseLinerName;
    }

    public Long getCruiseID() {
        return CruiseID;
    }

    public void setCruiseID(Long cruiseID) {
        CruiseID = cruiseID;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Date getCruiseStartDate() {
        return CruiseStartDate;
    }

    public void setCruiseStartDate(Date cruiseStartDate) {
        CruiseStartDate = cruiseStartDate;
    }

    public Date getCruiseEndDate() {
        return CruiseEndDate;
    }

    public void setCruiseEndDate(Date cruiseEndDate) {
        CruiseEndDate = cruiseEndDate;
    }

    public String getCruiseLinerName() {
        return CruiseLinerName;
    }

    public void setCruiseLinerName(String cruiseLinerName) {
        CruiseLinerName = cruiseLinerName;
    }
}
