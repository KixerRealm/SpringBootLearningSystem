package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAll();
    Optional<Course> save(String name, String description, String content);

    Optional<Course> edit(Long id, String name, String description, String content);

    void deleteById(Long id);

    Optional<Course> findById(Long id);
}
