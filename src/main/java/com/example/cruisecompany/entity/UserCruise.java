package com.example.cruisecompany.entity;

import java.util.Objects;

public class UserCruise {

    private Long ticketID;
    private Integer cabinNumber;
    private Cruise cruise;
    private User user;
    private Integer statusId;

    public UserCruise(Long ticketID, Integer cabinNumber, Cruise cruise, User user, Integer statusId) {
        this.ticketID = ticketID;
        this.cabinNumber = cabinNumber;
        this.cruise = cruise;
        this.user = user;
        this.statusId = statusId;
    }

    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getCabinNumber() {
        return cabinNumber;
    }

    public void setCabinNumber(Integer cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "ticketID=" + ticketID +
                ", cabinNumber=" + cabinNumber +
                ", cruise=" + cruise +
                ", user=" + user +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCruise that = (UserCruise) o;
        return Objects.equals(ticketID, that.ticketID) && Objects.equals(cabinNumber, that.cabinNumber) && Objects.equals(cruise, that.cruise) && Objects.equals(user, that.user) && Objects.equals(statusId, that.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, cabinNumber, cruise, user, statusId);
    }
}
