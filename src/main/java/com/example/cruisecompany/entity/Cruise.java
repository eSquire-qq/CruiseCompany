package com.example.cruisecompany.entity;

import java.util.Date;
import java.util.Objects;

public class Cruise {

    private Integer duration;
    private Integer price;
    private Date cruiseStartDate;
    private Date cruiseEndDate;
    private String cruiseLinerName;
    private Integer passengerCapacity;
    private Integer status;
    private Long cruiseId;

    public Cruise(Integer duration, Integer price, Date cruiseStartDate, Date cruiseEndDate, String cruiseLinerName,
                  Integer passengerCapacity, Integer status) {
        this.duration = duration;
        this.price = price;
        this.cruiseStartDate = cruiseStartDate;
        this.cruiseEndDate = cruiseEndDate;
        this.cruiseLinerName = cruiseLinerName;
        this.passengerCapacity = passengerCapacity;
        this.status = status;
    }

    public Cruise(Long cruiseId) {
        this.cruiseId = cruiseId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCruiseStartDate() {
        return cruiseStartDate;
    }

    public void setCruiseStartDate(Date cruiseStartDate) {
        this.cruiseStartDate = cruiseStartDate;
    }

    public Date getCruiseEndDate() {
        return cruiseEndDate;
    }

    public void setCruiseEndDate(Date cruiseEndDate) {
        this.cruiseEndDate = cruiseEndDate;
    }

    public String getCruiseLinerName() {
        return cruiseLinerName;
    }

    public void setCruiseLinerName(String cruiseLinerName) {
        this.cruiseLinerName = cruiseLinerName;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Long cruiseId) {
        this.cruiseId = cruiseId;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "duration=" + duration +
                ", price=" + price +
                ", cruiseStartDate=" + cruiseStartDate +
                ", cruiseEndDate=" + cruiseEndDate +
                ", cruiseLinerName='" + cruiseLinerName + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", status=" + status +
                ", cruiseId=" + cruiseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruise cruise = (Cruise) o;
        return Objects.equals(duration, cruise.duration) && Objects.equals(price, cruise.price) && Objects.equals(cruiseStartDate, cruise.cruiseStartDate)
                && Objects.equals(cruiseEndDate, cruise.cruiseEndDate) && Objects.equals(cruiseLinerName, cruise.cruiseLinerName)
                && Objects.equals(passengerCapacity, cruise.passengerCapacity) && Objects.equals(status, cruise.status) && Objects.equals(cruiseId, cruise.cruiseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, price, cruiseStartDate, cruiseEndDate, cruiseLinerName, passengerCapacity, status, cruiseId);
    }
}
