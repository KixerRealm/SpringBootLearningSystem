package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}
