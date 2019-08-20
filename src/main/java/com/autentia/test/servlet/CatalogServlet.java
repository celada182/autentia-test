package com.autentia.test.servlet;

import com.autentia.test.service.CourseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {
    private CourseService service;

    public CatalogServlet() {
        super();
        this.service = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        req.setAttribute("courses", service.getCourses());
        requestDispatcher.forward(req, resp);
    }
}
