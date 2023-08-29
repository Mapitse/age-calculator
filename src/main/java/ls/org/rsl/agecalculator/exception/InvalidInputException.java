package ls.org.rsl.agecalculator.exception;

public class InvalidInputException extends RuntimeException{
    private String message;

    public InvalidInputException(String message) {
        super(message);
    }
}
