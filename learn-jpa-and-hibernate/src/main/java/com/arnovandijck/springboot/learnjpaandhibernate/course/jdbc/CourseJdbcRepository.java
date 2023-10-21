package com.arnovandijck.springboot.learnjpaandhibernate.course.jdbc;

import com.arnovandijck.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insertCourse(Course course) {
        String INSERT_COURSE = "INSERT INTO TBL_COURSE (ID, TITLE, DESCRIPTION) VALUES (?, ?, ?)";
        springJdbcTemplate.update(INSERT_COURSE, course.getId(), course.getTitle(), course.getDescription());
    }

    public Course findCourseById(long id) {
        String SELECT_COURSE_BY_ID = "SELECT * FROM TBL_COURSE WHERE ID = ?";
        return springJdbcTemplate.queryForObject(SELECT_COURSE_BY_ID,  new BeanPropertyRowMapper<>(Course.class), id);
    }

    public void deleteCourseById(long id) {
        String DELETE_COURSE_BY_ID = "DELETE FROM TBL_COURSE WHERE ID = ?";
        springJdbcTemplate.update(DELETE_COURSE_BY_ID, id);
    }

}
