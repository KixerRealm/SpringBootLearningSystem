package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(length = 255)
    private String description;

    @Column(length = 1_000_000_000)
    private String content;

    @ManyToOne
    private User user;

    public Course(String name, String description, String content) {
        this.name = name;
        this.description = description;
        this.content = content;
    }

    public Course() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
