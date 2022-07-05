package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.QuestionForm;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;

import java.util.List;
import java.util.Optional;

public interface QuizService {

    List<Quiz> listAll();

    Optional<Quiz> save(String quizText);

    Optional<Quiz> edit(Long id, String quizName);

    void deleteById(Long id);

    Optional<Quiz> findById(Long id);

    void saveScore(Result result);

    int getResult(QuestionForm qForm);

    QuestionForm getQuestions();

    QuestionForm getTestQuestions();
}
