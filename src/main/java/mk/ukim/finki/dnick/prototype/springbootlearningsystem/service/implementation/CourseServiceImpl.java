package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.implementation;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.CourseRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Course> save(String name, String description, String content) {
        Course course = new Course(name,description, content);
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> edit(Long id, String name, String description, String content) {
        Course course = this.courseRepository.findById(id).orElseThrow(CourseDoesNotExistException::new);
        course.setName(name);
        course.setDescription(description);
        course.setContent(content);
        this.courseRepository.save(course);
        return Optional.of(course);
    }


    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
}
