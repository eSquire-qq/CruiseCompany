package com.example.cruisecompany.entity;

import java.util.Date;
import java.util.Objects;

public class Cruise {

    private Long id;
    private Integer duration;
    private Double price;
    private Date cruise_start_date;
    private Date cruise_end_date;
    private String cruise_liner_name;
    private Integer passenger_capacity;
    private CruiseStatus status;

    public Cruise(Long id, Integer duration, Double price, Date cruise_start_date, Date cruise_end_date, String cruise_liner_name, Integer passenger_capacity, CruiseStatus status) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.cruise_start_date = cruise_start_date;
        this.cruise_end_date = cruise_end_date;
        this.cruise_liner_name = cruise_liner_name;
        this.passenger_capacity = passenger_capacity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCruise_start_date() {
        return cruise_start_date;
    }

    public void setCruise_start_date(Date cruise_start_date) {
        this.cruise_start_date = cruise_start_date;
    }

    public Date getCruise_end_date() {
        return cruise_end_date;
    }

    public void setCruise_end_date(Date cruise_end_date) {
        this.cruise_end_date = cruise_end_date;
    }

    public String getCruise_liner_name() {
        return cruise_liner_name;
    }

    public void setCruise_liner_name(String cruise_liner_name) {
        this.cruise_liner_name = cruise_liner_name;
    }

    public Integer getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(Integer passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public CruiseStatus getStatus() {
        return status;
    }

    public void setStatus(CruiseStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", duration=" + duration +
                ", price=" + price +
                ", cruise_start_date=" + cruise_start_date +
                ", cruise_end_date=" + cruise_end_date +
                ", cruise_liner_name='" + cruise_liner_name + '\'' +
                ", passenger_capacity=" + passenger_capacity +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruise cruise = (Cruise) o;
        return Objects.equals(id, cruise.id) && Objects.equals(duration, cruise.duration) && Objects.equals(price, cruise.price) && Objects.equals(cruise_start_date, cruise.cruise_start_date) && Objects.equals(cruise_end_date, cruise.cruise_end_date) && Objects.equals(cruise_liner_name, cruise.cruise_liner_name) && Objects.equals(passenger_capacity, cruise.passenger_capacity) && status == cruise.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, price, cruise_start_date, cruise_end_date, cruise_liner_name, passenger_capacity, status);
    }
}
