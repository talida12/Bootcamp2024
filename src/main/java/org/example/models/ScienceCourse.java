package org.example.models;

public class ScienceCourse extends Course {

    public ScienceCourse() {
        super("Science");
    }

    @Override
    public double calculateGrade(int testScore, int assignmentScore, int attendanceScore) {
        return 0.3 * testScore + 0.6 * assignmentScore + 0.1 * attendanceScore;
    }
}
