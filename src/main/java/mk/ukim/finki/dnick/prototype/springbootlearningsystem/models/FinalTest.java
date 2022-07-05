package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@Setter
@Getter
public class FinalTest {

    @Id
    @GeneratedValue
    private Long id;

    private String finalTestName;

    @ManyToMany
    private List<Question> questions;

    public FinalTest(String finalTestName) {
        this.finalTestName = finalTestName;
    }

    public FinalTest() {
    }
}
