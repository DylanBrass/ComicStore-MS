package com.comicstore.clientservice.Utils.Exceptions;

public class DuplicateClientInformationException extends RuntimeException{
    public DuplicateClientInformationException() {}

    public DuplicateClientInformationException(String message) { super(message); }

    public DuplicateClientInformationException(Throwable cause) { super(cause); }

    public DuplicateClientInformationException(String message, Throwable cause) { super(message, cause); }

}
