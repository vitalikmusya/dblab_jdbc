package org.mus.rest.exception.not.found;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(final String message) {
        super(message);
    }

    public ItemNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
