package org.example.exceptions;

public class InvalidNumberOfFieldsException extends RuntimeException{
    //TODO throw nr of actual fields?


    public InvalidNumberOfFieldsException() {
        super("Number of fields must be >=2 AND <=50");
    }
}
