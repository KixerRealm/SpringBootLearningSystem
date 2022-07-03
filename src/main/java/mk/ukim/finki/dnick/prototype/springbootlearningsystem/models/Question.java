package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Component
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private int ans;
    private int chose;

    public Question(String questionText, String optionA, String optionB, String optionC, int ans, int chose) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.ans = ans;
        this.chose = chose;
    }

    public Question() {
    }
}
