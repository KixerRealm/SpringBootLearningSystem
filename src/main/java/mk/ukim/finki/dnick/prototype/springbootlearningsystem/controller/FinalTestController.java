package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.FinalTest;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.QuestionForm;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Result;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.QuizDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.FinalTestRepository;
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
@RequestMapping("/final-test")
public class FinalTestController {

    private final QuizService quizService;
    private final ResultRepository resultRepository;

    private final FinalTestRepository finalTestRepository;

    @Autowired
    Result result;
    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

    public FinalTestController(QuizService quizService, ResultRepository resultRepository, FinalTestRepository finalTestRepository) {
        this.quizService = quizService;
        this.resultRepository = resultRepository;
        this.finalTestRepository = finalTestRepository;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String getFinalTestPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<FinalTest> tests = this.finalTestRepository.findAll();
        model.addAttribute("tests", tests);
        model.addAttribute("bodyContent","final-test");
        return "master-template";
    }

    @GetMapping("/open-test/{id}")
    @PreAuthorize("isAuthenticated()")
    public String openFinalTestPage(@PathVariable Long id, Model model){
        this.finalTestRepository.findById(id).orElseThrow().setQuestions(quizService.getTestQuestions().getQuestions());
        QuestionForm qForm = quizService.getTestQuestions();
        submitted = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            result.setUsername(username);
        }
        model.addAttribute("qForm", qForm);
        return "open-test";
    }

    @PostMapping("/submit")
    public String submitQuiz(@ModelAttribute QuestionForm qForm, Model m){
        if(!submitted) {
            result.setTotalCorrect(quizService.getResult(qForm));
            quizService.saveScore(result);
            submitted = true;
        }
        m.addAttribute("result",result);
        m.addAttribute("bodyContent", "final-result");
        return "master-template";
    }

    @GetMapping("/certificate")
    public String getCertificate(Model m){
        m.addAttribute("result", result);
        m.addAttribute("bodyContent", "certificate");
        return "master-template";
    }
}
