package exception.uncheck;

public class MyUncheckException extends RuntimeException {
    public MyUncheckException(String message) {
        super(message);
    }
}
