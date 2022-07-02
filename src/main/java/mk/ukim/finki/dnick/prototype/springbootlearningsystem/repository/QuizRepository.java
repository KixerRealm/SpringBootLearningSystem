package mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
