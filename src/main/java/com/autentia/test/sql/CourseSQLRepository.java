package com.autentia.test.sql;

import com.autentia.test.repository.CourseRepository;
import com.autentia.test.sql.adapter.CourseAdapter;
import com.autentia.test.sql.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseSQLRepository implements CourseRepository {

    private final static Logger LOGGER = Logger.getLogger("CourseRepository");

    private Connection connection;
    private CourseAdapter adapter;

    public CourseSQLRepository() {
        adapter = new CourseAdapter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/autentia", "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, e.getClass().toString() + ": " + e.getMessage());
        }
    }

    public List<com.autentia.test.domain.Course> selectAll() {
        String query = "SELECT * FROM courses";
        List<Course> courses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getString("id"),
                        resultSet.getBoolean("active"),
                        resultSet.getString("title"),
                        resultSet.getString("professor"),
                        resultSet.getString("level"),
                        resultSet.getInt("hours")
                );
                courses.add(course);
            }
            statement.close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error: " + e.getMessage());
        }
        LOGGER.log(Level.INFO, "Courses retrieved: " + courses.toString());
        return adapter.adapt(courses);
    }

    @Override
    public void insert(com.autentia.test.domain.Course course) {
        String query = String.format("INSERT INTO courses (id, title, professor, level, hours, active) VALUES ('%s', '%s', '%s', '%s', %d, %b)",
                course.getId(), course.getTitle(), course.getProfessor(), course.getLevel().name(), course.getHours(), course.isActive());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            LOGGER.log(Level.INFO, "Course inserted: " + course.toString());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }
}
