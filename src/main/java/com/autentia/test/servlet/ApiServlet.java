package com.autentia.test.servlet;

import com.autentia.test.domain.Course;
import com.autentia.test.service.CourseService;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

public class ApiServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger("ApiServlet");

    private CourseService service;
    private Gson gson;

    public ApiServlet() {
        super();
        this.gson = new Gson();
        this.service = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        try {
            List<Course> courses = this.service.getCourses();
            String result = this.gson.toJson(courses);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(result);
            out.flush();
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(e.getMessage());
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        try {
            String body = bodyAsString(req);
            Course course = this.gson.fromJson(body, Course.class);
            this.service.addCourse(course.getTitle(), course.getProfessor(), course.getLevel().name(), course.getHours(), course.isActive());
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print("{\"response\": \"Course added\"}");
            out.flush();
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(e.getMessage());
            out.flush();
        }
    }

    private String bodyAsString(HttpServletRequest req) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            body.append(line);
        }
        return body.toString();
    }
}
