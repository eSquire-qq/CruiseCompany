package com.example.cruisecompany.entity;

import java.util.Objects;

public class UserCruise {

    private Long ticket_id;
    private Integer cabinNumber;
    private Cruise cruise;
    private User user;
    private Integer statusId;

    public UserCruise(Long ticket_id, Integer cabinNumber, Cruise cruise, User user, Integer statusId) {
        this.ticket_id = ticket_id;
        this.cabinNumber = cabinNumber;
        this.cruise = cruise;
        this.user = user;
        this.statusId = statusId;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
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
                "ticket_id=" + ticket_id +
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
        return Objects.equals(ticket_id, that.ticket_id) && Objects.equals(cabinNumber, that.cabinNumber) && Objects.equals(cruise, that.cruise) && Objects.equals(user, that.user) && Objects.equals(statusId, that.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket_id, cabinNumber, cruise, user, statusId);
    }
}
