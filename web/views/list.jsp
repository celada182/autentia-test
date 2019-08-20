<%@ page import="com.autentia.test.domain.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Catálogo de cursos</title>
</head>
<body>
<h1>Catálogo de cursos</h1>

<div>Lista de cursos</div>
<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");

    if (courses != null && !courses.isEmpty()) {
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Título</th>");
        out.println("<th>Profesor</th>");
        out.println("<th>Nivel</th>");
        out.println("<th>Horas</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (Course c : courses) {
            out.println("<tr>");
            out.println("<th>" + c.getTitle() + "</th>");
            out.println("<th>" + c.getProfessor() + "</th>");
            out.println("<th>" + c.getLevel() + "</th>");
            out.println("<th>" + c.getHours() + "</th>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
    } else {
        out.println("<p>No hay cursos</p>");
    }
%>

<button onclick="location.href='/nuevo'">Nuevo curso</button>
</body>
</html>
