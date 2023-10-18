package com.arnovandijck.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1, "Spring", "10 Steps"),
                new Course(2, "Spring MVC", "10 Examples"),
                new Course(3, "Spring Boot", "6K Students"),
                new Course(4, "Maven", "Most popular maven course on internet!"),
                new Course(5, "Docker", "Most popular docker course on internet!")
        );
    }
}
