package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.QuestionForm;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Quiz;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.QuizDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    Result result;
    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
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
        Quiz quiz = this.quizService.findById(id).orElseThrow(QuizDoesNotExistException::new);
        model.addAttribute("quiz", quiz);
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
            //result.setTotalCorrect(qService.getResult(qForm));
            //qService.saveScore(result);
            submitted = true;
        }
        return " ";
    }
//
//    @PostMapping("/add")
//    public String saveQuiz(
//            @RequestParam(required = false) Long id,
//            @RequestParam String name,
//            @RequestParam String description,
//            @RequestParam String content) {
//        if (id != null) {
//            this.courseService.edit(id, name, description, content);
//        } else {
//            this.courseService.save(name, description, content);
//        }
//        return "redirect:/lectures";
//    }
//
//    @GetMapping("/edit-form/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public String editCoursePage(@PathVariable Long id, Model model) {
//        if (this.courseService.findById(id).isPresent()) {
//            Course course = this.courseService.findById(id).orElseThrow(CourseDoesNotExistException::new);
//            model.addAttribute("course", course);
//            model.addAttribute("bodyContent", "add-lecture");
//            return "master-template";
//        }
//        return "redirect:/lectures?error=CourseNotFound";
//    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteQuiz(@PathVariable Long id) {
        this.quizService.deleteById(id);
        return "redirect:/quizzes";
    }

}
