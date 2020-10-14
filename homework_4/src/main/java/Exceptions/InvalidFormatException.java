package Exceptions;

public class InvalidFormatException extends Throwable {
    public InvalidFormatException(String message) {
        super(message);
        System.out.println("Received InvalidFormatException");
    }
}
