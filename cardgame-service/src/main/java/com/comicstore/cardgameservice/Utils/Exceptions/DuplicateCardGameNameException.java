package com.comicstore.cardgameservice.Utils.Exceptions;

public class DuplicateCardGameNameException extends RuntimeException{
    public DuplicateCardGameNameException() {}

    public DuplicateCardGameNameException(String message) { super(message); }

    public DuplicateCardGameNameException(Throwable cause) { super(cause); }

    public DuplicateCardGameNameException(String message, Throwable cause) { super(message, cause); }

}
