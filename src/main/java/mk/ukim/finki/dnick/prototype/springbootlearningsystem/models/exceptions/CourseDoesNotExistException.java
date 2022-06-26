package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions;

public class CourseDoesNotExistException extends RuntimeException{
    public CourseDoesNotExistException() {
        super("Course does not exist!");
    }
}
