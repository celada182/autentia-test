package com.autentia.test.sql.entity;

import java.util.Objects;

public class Course {
    private String id;
    private boolean active;
    private String title;
    private String professor;
    private String level;
    private Integer hours;

    public Course(String id, boolean active, String title, String professor, String level, Integer hours) {
        this.id = id;
        this.active = active;
        this.title = title;
        this.professor = professor;
        this.level = level;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", active=" + active +
                ", title='" + title + '\'' +
                ", professor='" + professor + '\'' +
                ", level='" + level + '\'' +
                ", hours=" + hours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (active != course.active) return false;
        if (!Objects.equals(id, course.id)) return false;
        if (!Objects.equals(title, course.title)) return false;
        if (!Objects.equals(professor, course.professor)) return false;
        if (!Objects.equals(level, course.level)) return false;
        return Objects.equals(hours, course.hours);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (professor != null ? professor.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        return result;
    }
}
