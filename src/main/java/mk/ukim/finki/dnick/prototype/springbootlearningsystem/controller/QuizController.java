package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.QuestionForm;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.QuizDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.ResultRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;
    private final ResultRepository resultRepository;

    @Autowired
    Result result;
    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    public QuizController(QuizService quizService, ResultRepository resultRepository) {
        this.quizService = quizService;
        this.resultRepository = resultRepository;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String getQuizzesPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Quiz> quizzes = this.quizService.listAll();
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("bodyContent","quizzes");
        return "master-template";
    }

    @GetMapping("/open-quiz/{id}")
    @PreAuthorize("isAuthenticated()")
    public String openQuizPage(@PathVariable Long id, Model model){
        this.quizService.findById(id).orElseThrow(QuizDoesNotExistException::new).setQuestions(quizService.getQuestions().getQuestions());
        QuestionForm qForm = quizService.getQuestions();
        submitted = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            result.setUsername(username);
        }
        model.addAttribute("qForm", qForm);
        model.addAttribute("bodyContent","open-quiz");
        return "master-template";
    }


    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addQuizPage(Model model) {
        model.addAttribute("bodyContent", "add-quiz");
        return "master-template";
    }

    @PostMapping("/submit")
    public String submitQuiz(@ModelAttribute QuestionForm qForm, Model m){
        if(!submitted) {
            result.setTotalCorrect(quizService.getResult(qForm));
            quizService.saveScore(result);
            submitted = true;
        }
        m.addAttribute("result",result);
        m.addAttribute("bodyContent", "result");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveQuiz(
            @RequestParam(required = false) Long id,
            @RequestParam String name) {
        if (id != null) {
            this.quizService.edit(id, name);
        } else {
            this.quizService.save(name);
        }
        return "redirect:/quizzes";
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editCoursePage(@PathVariable Long id, Model model) {
        if (this.quizService.findById(id).isPresent()) {
            Quiz quiz = this.quizService.findById(id).orElseThrow(QuizDoesNotExistException::new);
            model.addAttribute("quiz", quiz);
            model.addAttribute("bodyContent", "add-quiz");
            return "master-template";
        }
        return "redirect:/quizzes?error=CourseNotFound";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteQuiz(@PathVariable Long id) {
        this.quizService.deleteById(id);
        return "redirect:/quizzes";
    }

}
