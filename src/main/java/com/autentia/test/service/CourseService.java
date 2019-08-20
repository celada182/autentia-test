package com.autentia.test.service;

import com.autentia.test.domain.Course;
import com.autentia.test.domain.Level;
import com.autentia.test.repository.CourseRepository;
import com.autentia.test.sql.CourseSQLRepository;

import java.util.List;
import java.util.logging.Logger;

public class CourseService {
    private final static Logger LOGGER = Logger.getLogger("CourseService");

    private CourseRepository repository;

    public CourseService() {
        repository = new CourseSQLRepository();
    }

    public List<Course> getCourses() {
        return this.repository.selectAll();
    }

    public void addCourse(String title, String professor, String level, Integer hours, boolean active) {
        try {
            Level courseLevel = Level.fromString(level);
            Course course = new Course("asd", true, title, professor, courseLevel.getLevel(), hours);
            if (!active) {
                course.setActive(false);
            }
            this.repository.insert(course);
        } catch (IllegalArgumentException e) {
            LOGGER.log(java.util.logging.Level.SEVERE, "Invalid course level");
        }
    }
}
