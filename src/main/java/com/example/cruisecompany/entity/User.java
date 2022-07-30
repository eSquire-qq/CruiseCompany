package com.example.cruisecompany.entity;

import java.util.Objects;

public class User {

    private String name;
    private String surname;
    private String phoneNumber;
    private UserRole roleId; // Змінити в інших класах на UserRole
    private Long id;
    // Створити клас з SQL запросами
    // Замінити класи на послідовність полів(як в БД)
    public User(String name, String surname, String phoneNumber, Integer roleId, Long passengerId) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
        this.id = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getPassengerId() {
        return id;
    }

    public void setPassengerId(Long passengerId) {
        this.id = passengerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", roleId=" + roleId +
                ", passengerId=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(roleId, user.roleId) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber, roleId, id);
    }
}
