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

    @ManyToOne
    private Question questions1;

    @ManyToOne
    private Question questions2;

    @ManyToOne
    private Question questions3;

    @ManyToOne
    private Question questions4;

    @ManyToOne
    private Question questions5;

    public Quiz(String quizName, Question questions1, Question questions2, Question questions3, Question questions4, Question questions5) {
        this.quizName = quizName;
        this.questions1 = questions1;
        this.questions2 = questions2;
        this.questions3 = questions3;
        this.questions4 = questions4;
        this.questions5 = questions5;
    }

    public Quiz() {
    }
}
