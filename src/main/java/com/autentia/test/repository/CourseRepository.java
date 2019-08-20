package com.autentia.test.repository;

import com.autentia.test.domain.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> selectAll();
    void insert(Course course);
}
