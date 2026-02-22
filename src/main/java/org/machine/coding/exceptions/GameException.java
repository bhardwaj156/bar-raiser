package org.machine.coding.exceptions;

public class GameException extends RuntimeException {

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameException(String message) {
        super(message);
    }
}
