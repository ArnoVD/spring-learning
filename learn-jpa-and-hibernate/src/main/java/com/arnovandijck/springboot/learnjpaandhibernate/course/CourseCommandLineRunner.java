package com.arnovandijck.springboot.learnjpaandhibernate.course;

//import com.arnovandijck.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
//import com.arnovandijck.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.arnovandijck.springboot.learnjpaandhibernate.course.springDataJpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository courseJdbcRepository;

//    @Autowired
//    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) {
        courseSpringDataJpaRepository.save(new Course(1, "Learn JPA and Hibernate", "Learn JPA and Hibernate basics"));
        courseSpringDataJpaRepository.save(new Course(2, "Learn Full Stack with Spring Boot and React", "Learn Full Stack with Spring Boot and React basics"));
        courseSpringDataJpaRepository.save(new Course(2332, "Learn Spring Boot", "Learn Spring Boot basics"));

        courseSpringDataJpaRepository.deleteById(1L);

        System.out.println(courseSpringDataJpaRepository.findById(2L));

        courseSpringDataJpaRepository.findAll().forEach(System.out::println);
        System.out.println(courseSpringDataJpaRepository.count());

        System.out.println(courseSpringDataJpaRepository.findByTitle("Learn Spring Boot"));
        System.out.println(courseSpringDataJpaRepository.findByDescription("Learn Spring Boot basics"));
    }
}
