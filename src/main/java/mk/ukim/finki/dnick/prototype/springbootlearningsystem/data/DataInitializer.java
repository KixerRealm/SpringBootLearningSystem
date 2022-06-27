package mk.ukim.finki.dnick.prototype.springbootlearningsystem.data;

import lombok.Getter;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Course;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.User;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto.CourseDto;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.enumerations.Role;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
//import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.UserService;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    public UserService userService;
    public CourseService courseService;

    public DataInitializer(CourseService courseService, UserService userService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @PostConstruct
    public void init(){
        this.courseService.save(new CourseDto("Course1", "Course  1 1 1 "));
        this.userService.register("professor1","professor1","professor1","Adam","Adamovski", Role.ROLE_ADMIN);
        //users.add(new User("riste.stojanov","rs","Riste","Stojanov"));
        //users.add(new User("ana.todorovska","at","Ana","Todorovska"));
    }


}
