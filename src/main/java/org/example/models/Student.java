package org.example.models;
import java.util.HashMap;
import java.util.Map;

public class Student implements Observer {
    private String name;
    private Map<String, Map<String, Integer>> courseGrades;

    public Student(String name) {
        this.name = name;
        this.courseGrades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addCourseGrades(String courseName, int testGrade, int assignmentGrade, int attendanceGrade) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("test", testGrade);
        grades.put("assignment", assignmentGrade);
        grades.put("attendance", attendanceGrade);
        courseGrades.put(courseName, grades);
    }

    public Map<String, Integer> getGradesForCourse(String courseName) {
        return courseGrades.get(courseName);
    }

    @Override
    public void update(String update) {
        System.out.println("New notification for " + name + "\n" + "[" + update + "]" + "\n");
    }

    public void printAllGrades() {
        System.out.println("Grades for " + name + ": ");
        for (String course : courseGrades.keySet()) {
            System.out.println(course + ": " + courseGrades.get(course));
        }
    }
}
