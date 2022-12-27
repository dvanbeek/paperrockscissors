package nl.hartwigmedical.exceptions;

/**
 * Exception for invalid user input
 */
public class InvalidChoiceException extends Throwable {

    public InvalidChoiceException(String message) {
        super(message);
    }
}
