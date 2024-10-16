package com.surbhikalra.healinghearts.exception;

//Exception class to handle user not found failure
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
