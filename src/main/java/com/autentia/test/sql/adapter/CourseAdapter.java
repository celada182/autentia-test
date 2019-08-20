package com.autentia.test.sql.adapter;

import com.autentia.test.sql.entity.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseAdapter {
    public com.autentia.test.domain.Course adapt(Course course) {
        return new com.autentia.test.domain.Course(
                course.getId(),
                course.isActive(),
                course.getTitle(),
                course.getProfessor(),
                course.getLevel(),
                course.getHours()
        );
    }

    public List<com.autentia.test.domain.Course> adapt(List<Course> courses) {
        return courses.stream()
                .map(this::adapt)
                .collect(Collectors.toList());
    }

    public Course adapt(com.autentia.test.domain.Course course) {
        return new Course(
                course.getId(),
                course.isActive(),
                course.getTitle(),
                course.getProfessor(),
                course.getLevel().name(),
                course.getHours()
        );
    }
}
