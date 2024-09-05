package org.example.exceptions;

public class InvalidLayoutSizeException extends RuntimeException{
    public InvalidLayoutSizeException() {
        super("Size of the layout must be a square (n x n");
    }
}
