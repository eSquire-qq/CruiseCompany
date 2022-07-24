package DataBase.Entity;

public class Passenger {

    private Long PassengerID;
    private String Name;
    private String Surname;
    private String PhoneNumber;

    public Passenger(Long passengerID, String name, String surname, String phoneNumber) {
        PassengerID = passengerID;
        Name = name;
        Surname = surname;
        PhoneNumber = phoneNumber;
    }

    public Long getPassengerID() {
        return PassengerID;
    }

    public void setPassengerID(Long passengerID) {
        PassengerID = passengerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
