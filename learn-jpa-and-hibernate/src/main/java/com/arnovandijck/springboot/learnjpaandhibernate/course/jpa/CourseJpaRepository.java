package com.arnovandijck.springboot.learnjpaandhibernate.course.jpa;

import com.arnovandijck.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertCourse(Course course) {
        entityManager.merge(course);
    }

    public Course findCourseById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteCourseById(long id) {
        Course course = findCourseById(id);
        entityManager.remove(course);
    }
}
