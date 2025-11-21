package emailcheck;

public class CustomEmailFormatException extends Exception {
    
    public CustomEmailFormatException() {
        super();
    }
    
    public CustomEmailFormatException(String message) {
        super(message);
    }
    
    public CustomEmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
