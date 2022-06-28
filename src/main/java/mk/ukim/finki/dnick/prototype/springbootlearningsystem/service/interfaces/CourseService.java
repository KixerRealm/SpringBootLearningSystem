package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.User;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAll();
    Optional<Course> save(String name, String description);

    Optional<Course> edit(Long id, String name, String description);

    void deleteById(Long id);

    Optional<Course> findById(Long id);
}
