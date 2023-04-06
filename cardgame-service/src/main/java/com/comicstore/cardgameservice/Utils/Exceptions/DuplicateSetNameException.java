package com.comicstore.cardgameservice.Utils.Exceptions;

public class DuplicateSetNameException extends RuntimeException{
    public DuplicateSetNameException() {}

    public DuplicateSetNameException(String message) { super(message); }

    public DuplicateSetNameException(Throwable cause) { super(cause); }

    public DuplicateSetNameException(String message, Throwable cause) { super(message, cause); }

}
