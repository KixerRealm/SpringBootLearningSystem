package mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.implementation;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.QuestionForm;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.QuizDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.QuestionRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.QuizRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.ResultRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final ResultRepository resultRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    Question question;
    @Autowired
    QuestionForm qForm;

    public QuizServiceImpl(QuizRepository quizRepository, ResultRepository resultRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.resultRepository = resultRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Quiz> listAll() {
        return this.quizRepository.findAll();
    }

    @Override
public Optional<Quiz> save(String quizText) {
        Quiz quiz = new Quiz(quizText);
        this.quizRepository.save(quiz);
        return Optional.of(quiz);
    }

    @Override
    public Optional<Quiz> edit(Long id, String quizName) {
        Quiz quiz = this.quizRepository.findById(id).orElseThrow(QuizDoesNotExistException::new);
        quiz.setQuizName(quizName);
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

    public QuestionForm getQuestions() {
        List<Question> allQues = questionRepository.findAll();
        List<Question> qList = new ArrayList<Question>();

        Random random = new Random();

        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qForm.setQuestions(qList);

        return qForm;
    }

    public int getResult(QuestionForm qForm) {
        int correct = 0;

        for(Question q: qForm.getQuestions())
            if(q.getAns() == q.getChose())
                correct++;

        return correct;
    }

    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        resultRepository.save(saveResult);
    }


}
