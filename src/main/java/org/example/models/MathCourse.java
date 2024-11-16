package org.example.models;

public class MathCourse extends Course {
    public MathCourse() {
        super("Math");
    }

    @Override
    public double calculateGrade(int testScore, int assignmentScore, int attendanceScore) {
        return 0.7 * testScore + 0.2 * assignmentScore + 0.1 * attendanceScore;
    }
}
