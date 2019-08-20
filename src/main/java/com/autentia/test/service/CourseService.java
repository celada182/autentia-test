package com.autentia.test.service;

import com.autentia.test.domain.Course;
import com.autentia.test.domain.Level;
import com.autentia.test.repository.CourseRepository;
import com.autentia.test.sql.CourseSQLRepository;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CourseService {
    private final static Logger LOGGER = Logger.getLogger("CourseService");

    private CourseRepository repository;

    public CourseService() {
        repository = new CourseSQLRepository();
    }

    public List<Course> getCourses() {
        return this.repository.selectAll()
                .stream()
                .filter(Course::isActive)
                .collect(Collectors.toList());
    }

    public void addCourse(String title, String professor, String level, Integer hours, boolean active) {
        try {
            Course course = new Course(UUID.randomUUID().toString(), active, title, professor, Level.valueOf(level).name(), hours);
            this.repository.insert(course);
        } catch (IllegalArgumentException e) {
            LOGGER.log(java.util.logging.Level.SEVERE, "Invalid course level");
        }
    }
}
