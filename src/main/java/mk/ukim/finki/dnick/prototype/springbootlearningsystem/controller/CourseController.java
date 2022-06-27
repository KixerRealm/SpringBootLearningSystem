package mk.ukim.finki.dnick.prototype.springbootlearningsystem.controller;

import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lectures")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService productService) {
        this.courseService = productService;
    }

    @GetMapping
    private List<Course> findAll() {
        return this.courseService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable String id) {
        return this.courseService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Course> save(@RequestBody CourseDto courseDto) {
        return this.courseService.save(courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Course> edit(@PathVariable String id, @RequestBody CourseDto courseDto) {
        return this.courseService.edit(id, courseDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        this.courseService.deleteById(id);
        if(this.courseService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
