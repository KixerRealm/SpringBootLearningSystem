package mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findAll();

    @Transactional
    void deleteById(Long id);

    Optional<Course> findById(Long id);

    void deleteByName(String name);
}
