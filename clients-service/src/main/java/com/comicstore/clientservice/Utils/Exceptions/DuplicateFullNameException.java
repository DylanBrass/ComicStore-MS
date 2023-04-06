package com.comicstore.clientservice.Utils.Exceptions;

public class DuplicateFullNameException extends RuntimeException{
    public DuplicateFullNameException() {}

    public DuplicateFullNameException(String message) { super(message); }

    public DuplicateFullNameException(Throwable cause) { super(cause); }

    public DuplicateFullNameException(String message, Throwable cause) { super(message, cause); }

}
