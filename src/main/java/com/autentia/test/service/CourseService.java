package com.autentia.test.service;

import com.autentia.test.domain.Course;
import com.autentia.test.domain.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CourseService {
    private final static Logger LOGGER = Logger.getLogger("CourseService");

    private List<Course> courses = new ArrayList<>();

    public CourseService() {
        init();
    }

    private void init() {
        courses.add(new Course("Curso 1", "Profesor 1", Level.EASY.getLevel(), 20));
        courses.add(new Course("Curso 2", "Profesor 2", Level.INTERMEDIATE.getLevel(), 25));
        courses.add(new Course("Curso 3", "Profesor 3", Level.HARD.getLevel(), 15));
        courses.add(new Course("Curso 4", "Profesor 4", Level.EASY.getLevel(), 30));
        courses.add(new Course("Curso 5", "Profesor 5", Level.INTERMEDIATE.getLevel(), 40));
    }

    public List<Course> getCourses() {
        return this.courses.stream()
                .filter(Course::isActive)
                .collect(Collectors.toList());
    }

    public void addCourse(String title, String professor, String level, Integer hours, boolean active) {
        try {
            Level courseLevel = Level.fromString(level);
            Course course = new Course(title, professor, courseLevel.getLevel(), hours);
            if (!active) {
                course.setActive(false);
            }
            courses.add(course);
        } catch (IllegalArgumentException e) {
            LOGGER.log(java.util.logging.Level.SEVERE, "Invalid course level");
        }
    }
}
