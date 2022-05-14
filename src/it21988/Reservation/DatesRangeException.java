package it21988.Reservation;

public class DatesRangeException extends Throwable {
    public DatesRangeException() {
        System.out.println("Dates shouldn't be more than 15 days apart.");
    }
}
