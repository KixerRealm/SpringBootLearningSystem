package mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
