package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.implementation;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.QuizDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.QuizRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> listAll() {
        return this.quizRepository.findAll();
    }

    @Override
public Optional<Quiz> save(String quizText, Question question1, Question question2,Question question3, Question question4, Question question5) {
        Quiz quiz = new Quiz(quizText, question1, question2, question3, question4, question5);
        this.quizRepository.save(quiz);
        return Optional.of(quiz);
    }

    @Override
    public Optional<Quiz> edit(Long id, String quizName, List<Question> questions) {
        Quiz quiz = this.quizRepository.findById(id).orElseThrow(QuizDoesNotExistException::new);
        quiz.setQuizName(quizName);
        //quiz.setQuestions(questions);
        this.quizRepository.save(quiz);
        return Optional.of(quiz);
    }

    @Override
    public void deleteById(Long id) {
        this.quizRepository.deleteById(id);
    }

    @Override
    public Optional<Quiz> findById(Long id) {
        return Optional.of(this.quizRepository.findById(id).orElseThrow(QuizDoesNotExistException::new));
    }
}
