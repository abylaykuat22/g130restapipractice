package kz.bitlab.g130restapipractice.exception;

public class IncorrectValueException extends RuntimeException {
    public IncorrectValueException() {
        super();
    }

    public IncorrectValueException(String message) {
        super(message);
    }
}
