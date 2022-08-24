package com.example.cruisecompany.entity;

import java.util.Objects;

public class UserCruise {

    private Long ticketId;
    private Integer cabinNumber;
    private Long cruiseId;
    private Long userId;
    private Integer statusId;

    public UserCruise(Long ticketId, Integer cabinNumber, Long cruiseId, Long userId, Integer statusId) {
        this.ticketId = ticketId;
        this.cabinNumber = cabinNumber;
        this.cruiseId = cruiseId;
        this.userId = userId;
        this.statusId = statusId;
    }

    public UserCruise() {

    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCabinNumber() {
        return cabinNumber;
    }

    public void setCabinNumber(Integer cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public Long getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Long cruiseId) {
        this.cruiseId = cruiseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "UserCruise{" +
                "ticketId=" + ticketId +
                ", cabinNumber=" + cabinNumber +
                ", cruiseId=" + cruiseId +
                ", userId=" + userId +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCruise that = (UserCruise) o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(cabinNumber, that.cabinNumber) && Objects.equals(cruiseId, that.cruiseId) && Objects.equals(userId, that.userId) && Objects.equals(statusId, that.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, cabinNumber, cruiseId, userId, statusId);
    }
}
