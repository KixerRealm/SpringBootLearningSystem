package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Component
@Entity
@Data
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int totalCorrect = 0;

    public Result() {
        super();
    }

    public Result(Long id, String username, int totalCorrect) {
        super();
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return username.equals(result.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
