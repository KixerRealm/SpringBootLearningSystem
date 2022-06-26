package mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.dto;

import lombok.Data;

@Data
public class CourseDto {
    private String name;

    private String description;

    public CourseDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
