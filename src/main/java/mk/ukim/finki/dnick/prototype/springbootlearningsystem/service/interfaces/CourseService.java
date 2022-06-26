package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.User;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> listAll();

    Optional<Course> save(CourseDto courseDto);

    Optional<Course> edit(String courseId, CourseDto courseDto);

    void deleteById(String id);

    Optional<Course> findById(String id);
}
