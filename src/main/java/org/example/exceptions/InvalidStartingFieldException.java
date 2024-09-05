package org.example.exceptions;

public class InvalidStartingFieldException extends RuntimeException{
    public InvalidStartingFieldException() {
        super("The starting field must not be a mine");
    }
}
