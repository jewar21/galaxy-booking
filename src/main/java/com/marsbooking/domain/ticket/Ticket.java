package com.marsbooking.domain.ticket;
public class Ticket {

    private String ticketNumber;
    private String seatClass;
    private String passengerName;
    private String reservationCode;
    private String reservationStatus;

    public Ticket(String ticketNumber, String seatClass, String passengerName, String reservationCode, String reservationStatus) {
        this.ticketNumber = ticketNumber;
        this.seatClass = seatClass;
        this.passengerName = passengerName;
        this.reservationCode = reservationCode;
        this.reservationStatus = reservationStatus;
    }

    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public String getSeatClass() { return seatClass; }
    public void setSeatClass(String seatClass) { this.seatClass = seatClass; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getReservationCode() { return reservationCode; }
    public void setReservationCode(String reservationCode) { this.reservationCode = reservationCode; }

    public String getReservationStatus() { return reservationStatus; }
    public void setReservationStatus(String reservationStatus) { this.reservationStatus = reservationStatus; }

    public void showInfo() {
        System.out.println("Ticket: " + ticketNumber);
        System.out.println("Seat Class: " + seatClass);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Reservation Code: " + reservationCode);
        System.out.println("Reservation Status: " + reservationStatus);
    }
}