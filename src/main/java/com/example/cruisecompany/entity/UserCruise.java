package com.example.cruisecompany.entity;

import java.util.Date;
import java.util.Objects;

public class UserCruise {

    private Long ticketId;
    private Integer cabinNumber;
    private Long cruiseId;
    private Long userId;
    private Integer statusId;
    private String nameOfCruise;
    private Date cruiseStartDate;
    private Date cruiseEndDate;
    private String document;

    public UserCruise(Long ticketId, Integer cabinNumber, Long cruiseId, Long userId, Integer statusId, String nameOfCruise, Date cruiseStartDate, Date cruiseEndDate, String document) {
        this.ticketId = ticketId;
        this.cabinNumber = cabinNumber;
        this.cruiseId = cruiseId;
        this.userId = userId;
        this.statusId = statusId;
        this.nameOfCruise = nameOfCruise;
        this.cruiseStartDate = cruiseStartDate;
        this.cruiseEndDate = cruiseEndDate;
        this.document = document;
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

    public String getNameOfCruise() {
        return nameOfCruise;
    }

    public void setNameOfCruise(String nameOfCruise) {
        this.nameOfCruise = nameOfCruise;
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "UserCruise{" +
                "ticketId=" + ticketId +
                ", cabinNumber=" + cabinNumber +
                ", cruiseId=" + cruiseId +
                ", userId=" + userId +
                ", statusId=" + statusId +
                ", nameOfCruise='" + nameOfCruise + '\'' +
                ", cruiseStartDate=" + cruiseStartDate +
                ", cruiseEndDate=" + cruiseEndDate +
                ", document='" + document + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCruise that = (UserCruise) o;
        return Objects.equals(ticketId, that.ticketId) && Objects.equals(cabinNumber, that.cabinNumber) && Objects.equals(cruiseId, that.cruiseId) && Objects.equals(userId, that.userId) && Objects.equals(statusId, that.statusId) && Objects.equals(nameOfCruise, that.nameOfCruise) && Objects.equals(cruiseStartDate, that.cruiseStartDate) && Objects.equals(cruiseEndDate, that.cruiseEndDate) && Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, cabinNumber, cruiseId, userId, statusId, nameOfCruise, cruiseStartDate, cruiseEndDate, document);
    }
}
