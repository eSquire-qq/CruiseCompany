package com.example.cruisecompany.entity;

import java.util.Objects;

public class UserCruise {

    private Long ticketId;
    private Integer cabinNumber;
    private Cruise cruise;
    private User user;
    private Integer statusId;

    public UserCruise(Long ticketId, Integer cabinNumber, Cruise cruise, User user, Integer statusId) {
        this.ticketId = ticketId;
        this.cabinNumber = cabinNumber;
        this.cruise = cruise;
        this.user = user;
        this.statusId = statusId;
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
                "ticket_id=" + ticketId +
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
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(cabinNumber, that.cabinNumber) && Objects.equals(cruise, that.cruise) && Objects.equals(user, that.user) && Objects.equals(statusId, that.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, cabinNumber, cruise, user, statusId);
    }
}
