package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documentation")
@PreAuthorize("isAuthenticated()")
public class DocumentationController {

    @GetMapping
    public String getDocumentationPage(Model model) {
        model.addAttribute("bodyContent", "documentation");
        return "master-template";
    }
}
