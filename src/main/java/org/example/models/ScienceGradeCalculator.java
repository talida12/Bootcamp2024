package org.example.models;

import org.example.factory.GradeCalculator;

public class ScienceGradeCalculator implements GradeCalculator {
    @Override
    public double calculateGrade(int testScore, int assignmentScore, int attendanceScore) {
        return 0.7 * testScore + 0.2 * assignmentScore + 0.1 * attendanceScore;
    }
}
