package com.goeuro.exceptions;

public class CSVException extends Exception{

    public CSVException(String message) {
        super(message);
    }

    public CSVException(Throwable cause) {
        super(cause);
    }
}
