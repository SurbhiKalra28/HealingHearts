package com.surbhikalra.healinghearts.exception;

//Exception class to handle appointment not found failure
public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
