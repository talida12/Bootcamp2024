package org.example.models;


public class EnglishCourse extends Course {
    public EnglishCourse() {
        super("English");
    }

    @Override
    public double calculateGrade(int testScore, int assignmentScore, int attendanceScore) {
        return  0.4 * testScore + 0.4 * assignmentScore + 0.2 * attendanceScore;
    }
}
