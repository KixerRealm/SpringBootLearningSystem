package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.exceptions.CourseDoesNotExistException;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import org.springframework.http.ResponseEntity;
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
            @RequestParam String description) {
        if (id != null) {
            this.courseService.edit(id, name, description);
        } else {
            this.courseService.save(name, description);
        }
        return "redirect:/lectures";
    }

    @GetMapping("/edit-form/{id}")
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
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return "redirect:/lectures";
    }




//    @GetMapping
//    private List<Course> findAll() {
//        return this.courseService.listAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Course> findById(@PathVariable String id) {
//        return this.courseService.findById(id)
//                .map(product -> ResponseEntity.ok().body(product))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Course> save(@RequestBody CourseDto courseDto) {
//        return this.courseService.save(courseDto)
//                .map(course -> ResponseEntity.ok().body(course))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Course> edit(@PathVariable String id, @RequestBody CourseDto courseDto) {
//        return this.courseService.edit(id, courseDto)
//                .map(product -> ResponseEntity.ok().body(product))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteById(@PathVariable String id) {
//        this.courseService.deleteById(id);
//        if(this.courseService.findById(id).isEmpty()) return ResponseEntity.ok().build();
//        return ResponseEntity.badRequest().build();
//    }
}
