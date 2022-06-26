package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.implementation;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.CourseRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> listAll() {
        return courseRepository.findAll().stream().distinct().collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<Course> save(CourseDto courseDto) {
        this.courseRepository.deleteByName(courseDto.getName());
        Course course = new Course(courseDto.getName(), courseDto.getDescription());
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> edit(String id, CourseDto productDto) {
        Course course = this.courseRepository.findById(id).orElseThrow(CourseDoesNotExistException::new);
        course.setName(productDto.getName());
        course.setDescription(productDto.getDescription());
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public void deleteById(String id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(String id) {
        return courseRepository.findById(id);
    }
}
