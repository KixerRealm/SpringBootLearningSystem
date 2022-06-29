package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lectures")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent","courses");
        return "master-template";
    }

    @GetMapping("/view-lecture/{id}")
    @PreAuthorize("isAuthenticated()")
    public String viewLecturePage(@PathVariable Long id, Model model){
        Course course = this.courseService.findById(id).orElseThrow(CourseDoesNotExistException::new);
        model.addAttribute("course", course);
        model.addAttribute("bodyContent","view-lecture");
        return "master-template";
    }


    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCoursePage(Model model) {
        model.addAttribute("bodyContent", "add-lecture");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveCourse(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String content) {
        if (id != null) {
            this.courseService.edit(id, name, description, content);
        } else {
            this.courseService.save(name, description, content);
        }
        return "redirect:/lectures";
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editCoursePage(@PathVariable Long id, Model model) {
        if (this.courseService.findById(id).isPresent()) {
            Course course = this.courseService.findById(id).orElseThrow(CourseDoesNotExistException::new);
            model.addAttribute("course", course);
            model.addAttribute("bodyContent", "add-lecture");
            return "master-template";
        }
        return "redirect:/lectures?error=CourseNotFound";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return "redirect:/lectures";
    }

}
