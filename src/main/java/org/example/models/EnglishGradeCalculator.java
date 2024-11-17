package org.example.models;

import org.example.factory.GradeCalculator;

public class EnglishGradeCalculator implements GradeCalculator {
    @Override
    public double calculateGrade(int testScore, int assignmentScore, int attendanceScore) {
        return 0.4 * testScore + 0.4 * assignmentScore + 0.2 * attendanceScore;
    }
}
