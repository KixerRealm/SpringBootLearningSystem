package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}
