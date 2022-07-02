package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> listAll();

    Optional<Quiz> save(String quizText, Question question1, Question question2,Question question3, Question question4, Question question5);

    Optional<Quiz> edit(Long id, String quizName, List<Question> questions);

    void deleteById(Long id);

    Optional<Quiz> findById(Long id);

}
