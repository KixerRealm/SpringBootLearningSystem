package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models;

import lombok.Data;

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

    @ManyToOne
    private User user;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
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
