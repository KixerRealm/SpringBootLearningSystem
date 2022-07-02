package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions;

public class QuizDoesNotExistException extends RuntimeException{

    public QuizDoesNotExistException() {
        super("Quiz does not exist!");
    }
}
