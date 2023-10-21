package com.arnovandijck.springboot.learnjpaandhibernate.course.springDataJpa;

import com.arnovandijck.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitle(String title);

    List<Course> findByDescription(String description);

}
