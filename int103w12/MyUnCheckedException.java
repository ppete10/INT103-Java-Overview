package exception;

public class MyUnCheckedException extends RuntimeException {
    public MyUnCheckedException() {
        super();
    }

    public MyUnCheckedException(String message) {
        super(message);
    }

    public MyUnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUnCheckedException(Throwable cause) {
        super(cause);
    }
}
