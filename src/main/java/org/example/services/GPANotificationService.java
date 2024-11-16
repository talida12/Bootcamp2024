package org.example.services;

import org.example.models.Student;
import org.example.models.Course;

import java.util.List;
import java.util.Map;

public class GPANotificationService {
    public void notifyObservers(List<Student> students, List<Course> courses) {
        for (Student student : students) {
            double totalScore = 0;
            int courseCount = 0;
            StringBuilder gradeNotification = new StringBuilder();

            for (Course course : courses) {
                Map<String, Integer> grades = student.getGradesForCourse(course.getCourseName());

                if (grades != null) {
                    int testGrade = grades.getOrDefault("test", 0);
                    int assignmentGrade = grades.getOrDefault("assignment", 0);
                    int attendanceGrade = grades.getOrDefault("attendance", 0);

                    double courseGrade = course.calculateGrade(testGrade, assignmentGrade, attendanceGrade);
                    gradeNotification.append(course.getCourseName())
                            .append(" Grade: ")
                            .append(String.format("%.2f", courseGrade))
                            .append("\n");

                    totalScore += courseGrade;
                    courseCount++;
                }
            }
            if (courseCount > 0) {
                double gpa = totalScore / courseCount;
                String letterGPA = getGradeLetter(gpa);
                gradeNotification.append("Average GPA: ").append(gpa).append( "(" + letterGPA + ")");
            } else {
                gradeNotification.append("No courses enrolled in.");
            }
            student.update(gradeNotification.toString());
        }

    }

    protected String getGradeLetter(double score) {
        int gradeCategory = (int) (score / 10);
        switch (gradeCategory) {
            case 10, 9: return "A";
            case 8: return "B";
            case 7: return "C";
            case 6: return "D";
            default: return "F";
        }
    }
}
