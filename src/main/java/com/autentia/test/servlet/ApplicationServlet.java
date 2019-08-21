package com.autentia.test.servlet;

import com.autentia.test.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger("ApplicationServlet");

    private CourseService service;

    public ApplicationServlet() {
        super();
        this.service = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getRequestURI()) {
            case "/nuevo":
                req.getRequestDispatcher("views/add.jsp").forward(req, resp);
                break;
            case "/catalogo":
            default:
                req.setAttribute("courses", service.getCourses());
                req.getRequestDispatcher("views/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String title = req.getParameter("title");
            String professor = req.getParameter("professor");
            String level = req.getParameter("level");
            Integer hours = Integer.valueOf(req.getParameter("hours"));
            boolean active = req.getParameter("active") != null;
            if (title == null || professor == null || level == null) {
                throw new NullPointerException("Missing course information");
            }
            this.service.addCourse(title, professor, level, hours, active);
            LOGGER.log(Level.INFO, "Course " + title + " added");
            resp.sendRedirect("/catalogo");
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
}
