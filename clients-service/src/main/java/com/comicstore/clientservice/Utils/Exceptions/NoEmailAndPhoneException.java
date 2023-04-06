package com.comicstore.clientservice.Utils.Exceptions;

public class NoEmailAndPhoneException extends RuntimeException{
    public NoEmailAndPhoneException() {}

    public NoEmailAndPhoneException(String message) { super(message); }

    public NoEmailAndPhoneException(Throwable cause) { super(cause); }

    public NoEmailAndPhoneException(String message, Throwable cause) { super(message, cause); }

}
