package org.example.models;

import org.example.factory.GradeCalculator;

public class ScienceCourse extends Course {

    public ScienceCourse() {
        super("Science");
    }

    @Override
    public GradeCalculator createGradeCalculator() {
        return new ScienceGradeCalculator();
    }

}
