package org.example.exceptions;

public class InvalidNumberOfFieldsException extends RuntimeException{
    public InvalidNumberOfFieldsException() {
        super("Number of fields must be >=2 AND <=50");
    }
}
