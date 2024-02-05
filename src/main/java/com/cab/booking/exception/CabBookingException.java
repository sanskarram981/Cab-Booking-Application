package com.cab.booking.exception;

public class CabBookingException extends RuntimeException {
    public CabBookingException(String message,Throwable cause)
    {
        super(message,cause);
    }
    public CabBookingException(String message)
    {
        super(message);
    }
}
