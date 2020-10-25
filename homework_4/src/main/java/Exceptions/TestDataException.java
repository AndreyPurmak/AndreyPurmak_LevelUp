package Exceptions;

public class TestDataException extends NullPointerException {
    public TestDataException(String message) {
        super(message);
        System.out.println("Received TestDataException");
    }
}
