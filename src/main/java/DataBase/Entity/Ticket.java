package DataBase.Entity;

public class Ticket {

    private Long TicketID;
    private Integer CabinNumber;
    private Long CruiseID;
    private Long PassengerID;

    public Ticket(Long ticketID, Integer cabinNumber, Long cruiseID, Long passengerID) {
        TicketID = ticketID;
        CabinNumber = cabinNumber;
        CruiseID = cruiseID;
        PassengerID = passengerID;
    }

    public Long getTicketID() {
        return TicketID;
    }

    public void setTicketID(Long ticketID) {
        TicketID = ticketID;
    }

    public Integer getCabinNumber() {
        return CabinNumber;
    }

    public void setCabinNumber(Integer cabinNumber) {
        CabinNumber = cabinNumber;
    }

    public Long getCruiseID() {
        return CruiseID;
    }

    public void setCruiseID(Long cruiseID) {
        CruiseID = cruiseID;
    }

    public Long getPassengerID() {
        return PassengerID;
    }

    public void setPassengerID(Long passengerID) {
        PassengerID = passengerID;
    }
}
