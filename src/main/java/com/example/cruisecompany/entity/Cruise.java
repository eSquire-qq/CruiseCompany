package com.example.cruisecompany.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Cruise {

    private Long id;
    private Double price;
    private LocalDate cruiseStartDate;
    private LocalDate cruiseEndDate;
    private String cruiseLinerName;
    private Integer passengerCapacity;
    private CruiseStatus status;
    private Integer duration;

    public Cruise(Long id, Double price, LocalDate cruiseStartDate, LocalDate cruiseEndDate, String cruiseLinerName, Integer passengerCapacity, CruiseStatus status, Integer duration) {
        this.id = id;
        this.price = price;
        this.cruiseStartDate = cruiseStartDate;
        this.cruiseEndDate = cruiseEndDate;
        this.cruiseLinerName = cruiseLinerName;
        this.passengerCapacity = passengerCapacity;
        this.status = status;
        this.duration = duration;
    }

    public Cruise() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getCruiseStartDate() {
        return cruiseStartDate;
    }

    public void setCruiseStartDate(LocalDate cruiseStartDate) {
        this.cruiseStartDate = cruiseStartDate;
    }

    public LocalDate getCruiseEndDate() {
        return cruiseEndDate;
    }

    public void setCruiseEndDate(LocalDate cruiseEndDate) {
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

    public CruiseStatus getStatus() {
        return status;
    }

    public void setStatus(CruiseStatus status) {
        this.status = status;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String
    toString() {
        return "Cruise{" +
                "id=" + id +
                ", price=" + price +
                ", cruiseStartDate=" + cruiseStartDate +
                ", cruiseEndDate=" + cruiseEndDate +
                ", cruiseLinerName='" + cruiseLinerName + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", status=" + status +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruise cruise = (Cruise) o;
        return Objects.equals(id, cruise.id) && Objects.equals(price, cruise.price) && Objects.equals(cruiseStartDate, cruise.cruiseStartDate) && Objects.equals(cruiseEndDate, cruise.cruiseEndDate) && Objects.equals(cruiseLinerName, cruise.cruiseLinerName) && Objects.equals(passengerCapacity, cruise.passengerCapacity) && status == cruise.status && Objects.equals(duration, cruise.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, cruiseStartDate, cruiseEndDate, cruiseLinerName, passengerCapacity, status, duration);
    }
}
