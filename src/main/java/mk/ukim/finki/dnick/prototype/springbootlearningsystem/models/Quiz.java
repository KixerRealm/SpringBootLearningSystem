package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    private String quizName;

    @ManyToMany
    private List<Question> questions;

    public Quiz(String quizName) {
        this.quizName = quizName;
    }

    public Quiz() {
    }
}
