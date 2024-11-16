package org.example.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
    protected String courseName;
    protected List<Student> enrolledStudents = new ArrayList<>();
    private List<String> generalNotifications = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }
    public abstract double calculateGrade(int testScore, int assignmentScore, int attendanceScore);

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student))
            enrolledStudents.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addGeneralNotification(String message) {
        generalNotifications.add(message);
    }

    public String getRandomNotification() {
        if (generalNotifications.isEmpty())
            return "No updates..";
        int index = (int) (Math.random() * generalNotifications.size());
        return generalNotifications.get(index);
    }
}
